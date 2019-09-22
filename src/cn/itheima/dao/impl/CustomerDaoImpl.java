package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    public void save(Customer c) {
        //获得session
        Session session = HibernateUtils.getCurrentSession();
        //执行事务
        session.save(c);
    }

    @Override
    public List<Customer> getAll() {
        //获得session
        Session session = HibernateUtils.getCurrentSession();
        //创建criteria对象
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer getById(Long cust_id) {
        //获得session
        Session session = HibernateUtils.getCurrentSession();
        return session.get(Customer.class, cust_id);
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        //获得session
        Session session = HibernateUtils.getCurrentSession();
        //将离线对象关联到session
        Criteria criteria = dc.getExecutableCriteria(session);
        List<Customer> list = criteria.list();
        return list;
    }
}
