package cn.itheima.service.impl;

import cn.itheima.dao.UserDao;
import cn.itheima.dao.impl.UserDaoImpl;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Transaction;

/**
 * @author nie
 */
public class UserServiceImpl implements UserService {
    private UserDao ud=new UserDaoImpl();

    //执行登录方法
    @Override
    public User login(User user) {
        //开启事务
        Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
        //1.根据登录用户名查询User对象
        User existU=ud.getByUserCode(user.getUser_code());
        //提交事务
        tx.commit();
        if (existU == null) {
            //查询不到抛出异常，用户名不存在
            throw new RuntimeException("用户名不存在!");
        }
        //2.比对密码是否一致
        //System.out.println(existU.getUser_password());
        //System.out.println(user.getUser_password());
        if (!existU.getUser_password().equals(user.getUser_password())) {
            //不一致，抛出异常，提示用户密码错误
            throw new RuntimeException("用户密码错误!");
        }

        return existU;
    }
}
