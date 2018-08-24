package lk.mapper;

import lk.pojo.User;

public interface UserDao {
    /**
     * 登陆
     * @param mail
     * @return
     */
    User loginByMail(String mail);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);
}
