package com.ksptooi.flr.dao.access;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;

public interface SqliteAccess {

    public SqlSession getSqlSession();

    public Session getSession();

}
