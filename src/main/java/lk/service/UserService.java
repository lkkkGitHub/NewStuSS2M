package lk.service;

import lk.mapper.UserDao;
import lk.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
                if (user.getDeleteFlag() == 1) {
                    stringBuffer.append("你的账号存在违规已被禁止登陆，请联系管理员");
                    return null;
                } else {
                    return user;
                }
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

    /**
     * 查询除管理员以外得用户信息
     *
     * @return
     */
    public List<User> findAllUserPvg0() {
        return userDao.findAllUserPvg0();
    }

    /**
     * 管理员逻辑删除用户
     *
     * @param user
     * @return
     */
    public int upUserDeleteFlagById(User user) {
        int i = userDao.upUserDeleteFlagById(user);
        if (i != 1) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    /**
     * 更新用户除id密码之外的信息
     * @param user
     * @return
     */
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }
}
