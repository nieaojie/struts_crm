package cn.itheima.service.impl;
import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.dao.impl.CustomerDaoImpl;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        //打开事务
        Transaction tx = session.beginTransaction();
        try {
            customerDao.save(c);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //关闭事务
        tx.commit();
    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Customer> customerList = null;
        try {
            customerList = customerDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //关闭事务
        tx.commit();
        return customerList;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Customer> customerList = null;
        try {
            customerList = customerDao.getAll(dc);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //关闭事务
        tx.commit();
        return customerList;
    }
}
