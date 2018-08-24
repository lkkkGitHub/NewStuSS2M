package lk.mapper;

import lk.pojo.User;

import java.util.List;

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

    /**
     * 查询除管理员以外得所有用户
     * @param id
     * @return
     */
    List<User> findAllNotDeleteUser();
}
