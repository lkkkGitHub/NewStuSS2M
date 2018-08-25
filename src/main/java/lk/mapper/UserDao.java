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
     *
     * @return
     */
    List<User> findAllNotDeleteUser();

    /**
     * 管理员逻辑删除用户
     *
     * @param user
     * @return
     */
    int upUserDeleteFlagById(User user);
}
