package lk.controller;

import lk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lk
 * 2018/8/20 14:22
 * @description:
 */
public class UserAction {

    @Autowired
    private UserService userService;

    public String findUser() {
        System.out.print(userService.finUser(1001));
        return "index";
    }
}
