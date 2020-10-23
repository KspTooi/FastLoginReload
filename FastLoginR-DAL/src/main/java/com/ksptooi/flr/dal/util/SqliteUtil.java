package com.ksptooi.flr.dal.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SqliteUtil {

    public static SessionFactory sessionFactory = null;

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    static{

        //加载配置文件管理
        Configuration cfg = new Configuration();
        cfg.configure("hibernate-sqlite.xml");
        sessionFactory = cfg.buildSessionFactory();

    }

}
