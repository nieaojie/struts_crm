package cn.itheima.dao.impl;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author nie
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getByUserCode(String user_code) {
        //HQL查询
        //1.获得session
        Session session = HibernateUtils.getCurrentSession();
        //2.书写HQL
        String sql = "from User where user_code=?";
        //3.创建查询对象
        Query query = session.createQuery(sql);
        //4.设置参数
        query.setParameter(0, user_code);
        //5.执行查询
        User u = (User) query.uniqueResult();
        return u;
    }
}
