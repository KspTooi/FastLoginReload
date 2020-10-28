package com.ksptooi.flr.dao.access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMysqlAccess {

    public static SessionFactory sessionFactory = null;

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    static{

        //加载配置文件管理
        Configuration cfg = new Configuration();
        cfg.configure("hibernate-mysql.xml");
        sessionFactory = cfg.buildSessionFactory();

    }

}
