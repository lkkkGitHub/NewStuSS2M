package lk.mapper;

import lk.pojo.User;

public interface UserDao {
    User findUserById(Integer id);
}
