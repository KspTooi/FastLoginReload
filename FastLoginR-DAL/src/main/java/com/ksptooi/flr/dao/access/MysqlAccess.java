package com.ksptooi.flr.dao.access;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;

public interface MysqlAccess {

    public SqlSession getSqlSession();

    public Session getSession();

}
