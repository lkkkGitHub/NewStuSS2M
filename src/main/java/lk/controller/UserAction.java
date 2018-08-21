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

    private String mail;
    private String password;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User user = userService.loginByMain(mail, password, stringBuffer);
        if (user == null) {
            return "login";
        } else {
            Cookie mailCookie = new Cookie("mail", mail);
            Cookie passwordCookie = new Cookie("password", password);
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
        User user = new User(firstName, lastName, mail, password);
        userService.register(user);
        return "register";
    }
}
