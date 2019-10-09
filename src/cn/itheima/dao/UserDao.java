package cn.itheima.dao;

import cn.itheima.domain.User;

/**
 * @author nie
 */
public interface UserDao {
    /**
     * @param user_code
     * @return user
     * description:根据用户名返回user
     */
    User getByUserCode(String user_code);
}
