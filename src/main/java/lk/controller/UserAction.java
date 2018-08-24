package lk.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lk.pojo.User;
import lk.service.UserService;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author lk
 * 2018/8/20 14:22
 * @description:
 */
public class UserAction extends ActionSupport implements RequestAware {

    private User user;

    private String passwordTwo;

    private Map<String, Object> request;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
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
        StringBuffer stringBuffer = new StringBuffer();
        User user1 = userService.loginByMain(user.getMail(), user.getPassword(), stringBuffer);
        if (user1 == null) {
            request.put("message", stringBuffer);
            return Action.INPUT;
        } else {
            ActionContext.getContext().getSession().put("loginUser", user1);
            return Action.SUCCESS;
        }
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
        userService.register(user);
        return "index";
    }

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
}
