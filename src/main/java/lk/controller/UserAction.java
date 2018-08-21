package lk.controller;

import lk.pojo.User;
import lk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;

/**
 * @author lk
 * 2018/8/20 14:22
 * @description:
 */
public class UserAction {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    private UserService userService;

    /**
     * 跳转到登陆页面
     * @return
     */
    public String showLogin() {
        return "login";
    }

    /**
     * 登陆post
     * @return
     */
    public String login() {
        StringBuffer stringBuffer = new StringBuffer();
        User user1 = userService.loginByMain(user.getMail(), user.getPassword(), stringBuffer);
        if (user1 == null) {
            return "login";
        } else {
            Cookie mailCookie = new Cookie("mail", user.getMail());
            Cookie passwordCookie = new Cookie("password", user.getPassword());
            mailCookie.setMaxAge(30);
            passwordCookie.setMaxAge(30);
            return "index";
        }
    }

    /**
     * 跳转到注册界面
     * @return
     */
    public String showRegister() {
        return "register";
    }

    /**
     * 注册
     * @return
     */
    public String register() {
        userService.register(user);
        return "register";
    }
}
