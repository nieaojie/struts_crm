package cn.itheima.service.impl;
import cn.itheima.dao.CustomerDao;
import cn.itheima.dao.LinkManDao;
import cn.itheima.dao.impl.LinkManDaoImpl;
import cn.itheima.domain.Customer;
import cn.itheima.domain.LinkMan;
import cn.itheima.service.LinkManService;
import cn.itheima.dao.impl.CustomerDaoImpl;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LinkManServiceImpl implements LinkManService {
    private CustomerDao cd = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();
    //保存联系人
    @Override
    public void save(LinkMan lm) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            //1.根据客户id获得客户对象
            Long cust_id = lm.getCust_id();
            Customer c = cd.getById(cust_id);
            //2.将客户放入LinkMan中表达关系
            lm.setCustomer(c);
            //3.保存LinkMan
            lmd.save(lm);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }
}
