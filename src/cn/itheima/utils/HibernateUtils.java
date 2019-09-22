package cn.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sf;

    static {
        //1.创建，调用空参构造
        Configuration conf = new Configuration().configure();
        //2.根据配置信息，创建SessionFactory对象
        sf = conf.buildSessionFactory();
    }

    //获得session=>全新的session
    public static Session openSession() {
        //获得session
        Session session = sf.openSession();
        return session;
    }

    public static Session getCurrentSession() {
        //获得session
        Session session = sf.getCurrentSession();
        return session;
    }
}
