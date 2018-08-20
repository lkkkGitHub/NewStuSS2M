package lk.service;

import lk.mapper.UserDao;
import lk.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User finUser(Integer userId) {
        return userDao.findUserById(userId);
    }
}
