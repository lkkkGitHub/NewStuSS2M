package lk.service;

import lk.mapper.UserDao;
import lk.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 登陆
     *
     * @param mail
     * @param password
     * @param stringBuffer
     * @return
     */
    public User loginByMain(String mail, String password, StringBuffer stringBuffer) {
        User user = userDao.loginByMail(mail);
        if (user == null) {
            stringBuffer.append("账号不正确");
            return null;
        } else {
            if (user.getPassword().equals(password)) {
                stringBuffer.append("信息正确");
                return user;
            } else {
                stringBuffer.append("密码错误");
                return null;
            }
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public int register(User user) {
        return userDao.register(user);
    }
}
