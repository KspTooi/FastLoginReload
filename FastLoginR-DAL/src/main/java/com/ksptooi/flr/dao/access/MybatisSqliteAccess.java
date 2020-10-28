package com.ksptooi.flr.dao.access;

import org.apache.ibatis.session.SqlSession;

public class MybatisSqliteAccess implements MybatisAccess {


    public SqlSession getSqlSession() {
        System.out.println("测试测试测试测试IOC!");
        return null;
    }


    public String getCurDataBaseType() {
        return null;
    }
}
