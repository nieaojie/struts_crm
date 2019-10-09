package cn.itheima.service;

import cn.itheima.domain.User;

public interface UserService {
    /**
     * @param user
     * @return user对象
     * 执行登录业务
     */
    User login(User user);
}
