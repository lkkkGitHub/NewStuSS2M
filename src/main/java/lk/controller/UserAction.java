package lk.controller;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import lk.pojo.User;
import lk.service.UserService;
import lk.tools.GMailEngine;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/8/20 14:22
 * @description:
 */
public class UserAction extends ActionSupport {

    private User user;

    private String passwordTwo;

    //登录时提交的验证码就放在这里面
    private String captcha;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public ByteArrayInputStream getInputStreamForCaptcha() {
        return inputStreamForCaptcha;
    }

    private Map request = (Map) ActionContext.getContext().get("request");

    //用于输出验证码图片
    private ByteArrayInputStream inputStreamForCaptcha;

    //产生验证码图像的家伙，必须是静态的，因为创建它很费力气
    private static ImageCaptchaService captchaService = new DefaultManageableImageCaptchaService(
            new FastHashMapCaptchaStore(),
            new GMailEngine(),
            180,
            100000,
            75000);

    /**
     * 对所有方法都进行判断
     */
    public void validate() {

    }

    /**
     * 仅对登陆有效
     */
    public void validateLogin() {
        if (user.getMail().isEmpty()) {
            this.addFieldError("mail", "不能为空");
        }

        if (user.getPassword().isEmpty()) {
            this.addFieldError("password", "不能为空");
        }
    }

    /**
     * 仅对注册有效
     */
    public void validateRegister() {
        if (user.getFirstName().isEmpty()) {
            this.addFieldError("firstName", "不能为空");
        }

        if (user.getLastName().isEmpty()) {
            this.addFieldError("lastName", "不能为空");
        }

        if (user.getMail().isEmpty()) {
            this.addFieldError("mail", "不能为空");
        }

        if (user.getPassword().isEmpty()) {
            this.addFieldError("password", "不能为空");
        }

        if (!user.getPassword().equals(passwordTwo)) {
            this.addFieldError("passwordTwo", "与password字段必须一致");
        }
    }

    @Autowired
    private UserService userService;

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    public String showLogin() {
        return "login";
    }

    /**
     * 登陆post：
     * 从前台获取到用户输入的邮箱，以及密码；创建一个StringBuffer对象，
     * 和邮箱，以及密码一起传入到service中，通过stringBuffer对象将错误信息带回来，
     * 如果从service中返回的信息为空，即表示登陆信息错误，重新返回到登陆页面，并将错误信息返回到页面；
     * 返回不为空，即表示登陆信息正确，返回到主页，并将用户信息传入到session中
     *
     * @return
     */
    public String login() {

        //先查看验证码对不对
        Boolean isCaptchaOk = captchaService.validateResponseForID(
                ServletActionContext.getRequest().getSession().getId(), captcha);
        if (!isCaptchaOk) {
            addFieldError("captcha",
                    "验证码输入错误，建议配副眼镜！");
            return Action.INPUT;
        }

        StringBuffer stringBuffer = new StringBuffer();
        User user1 = userService.loginByMain(user.getMail(), user.getPassword(), stringBuffer);
        if (user1 == null) {
            request.put("messageLogin", stringBuffer);
            return Action.INPUT;
        } else {
            ActionContext.getContext().getSession().put("loginUser", user1);
            return Action.SUCCESS;
        }
    }

    //产生登录认证码
    public String getLoginCaptcha() throws IOException {
        //产生的图像编码压缩后的数据就放在这里面
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //获取Session id     (String)
            String captchaId =  ServletActionContext.getRequest().getSession().getId();
            //生成一个验证码图像，这个验证码与当前Session相关联
            BufferedImage challenge = captchaService.getImageChallengeForID(
                    captchaId, ActionContext.getContext().getLocale());

            //创建JPEG压缩对象
            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
            //压缩验证码图像，输出到jpegOutputStream
            jpegEncoder.encode(challenge);

        } catch (IllegalArgumentException e) {
            //TODO:出错处理，请自行修改完善
            return Action.ERROR;
        } catch (CaptchaServiceException e) {
            return Action.ERROR;
        } catch (IOException e) {
            return Action.ERROR;
        }

        //将JPEG数据保存到inputstream中，这个inputstrea就要返回的
        inputStreamForCaptcha = new ByteArrayInputStream(jpegOutputStream.toByteArray());
        inputStreamForCaptcha.close();

        //设置HTTP头的相关参数
        ServletActionContext.getResponse().setHeader("Cache-Control", "no-store");
        ServletActionContext.getResponse().setHeader("Pragma", "no-cache");
        ServletActionContext.getResponse().setDateHeader("Expires", 0);

        return Action.SUCCESS;
    }

    /**
     * 跳转到注册界面
     *
     * @return 登陆界面
     */
    public String showRegister() {
        return "register";
    }

    /**
     * 注册
     *
     * @return
     */
    public String register() {
        user.setPrivilege(1);
        userService.register(user);
        return "index";
    }

    /**
     * 返回除管理员外，所有得用户信息
     * https://gitee.com/niugao/xxqxkt.git
     *
     * @return
     */
    public String findAllUser() {
        List<User> list = userService.findAllUserPvg0();
        if (list.size() != 0) {
            request.put("users", list);
        } else {
            request.put("messageFind", "暂时没有查询到用户");
        }
        return Action.SUCCESS;
    }

    /**
     * 对用户进行逻辑删除
     *
     * @return
     */
    public String upUserDeleteFlagById() {
        int i = 0;
        if (user.getDeleteFlag() == 0) {
            user.setDeleteFlag(1);
            i = userService.upUserDeleteFlagById(user);
        } else {
            request.put("messageUpdate", "用户已经被标记为删除");
            return Action.ERROR;
        }
        if (i != 1) {
            request.put("messageUpdate", "更新失败");
            return Action.INPUT;
        } else {
            request.put("messageUpdate", "更新成功");
            return Action.SUCCESS;
        }
    }

    /**
     * 根据id 查询用户具体信息
     *
     * @return
     */
    public String findUserById() {
        User user1 = userService.findUserById(user.getId());
        request.put("user", user1);
        return Action.SUCCESS;
    }

    /**
     * 编辑用户信息
     *
     * @return
     */
    public String editUser() {
        int i = userService.updateUserInfo(user);
        return Action.SUCCESS;
    }
}
