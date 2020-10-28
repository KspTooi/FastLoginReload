package com.ksptooi.flr.dao.access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSqliteAccess {



    public static SessionFactory sessionFactory = null;

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    static{
        //加载配置文件管理
        Configuration cfg = new Configuration();
        cfg.configure("hibernate-sqlite.xml");
        cfg.getProperties().setProperty("hibernate.validator.apply_to_ddl","false");
        sessionFactory = cfg.buildSessionFactory();
    }

}
