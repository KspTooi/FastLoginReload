package com.ksptooi.flr.dao.access;

import org.apache.ibatis.session.SqlSession;

public interface MybatisAccess {

    public SqlSession getSqlSession();

    public String getCurDataBaseType();

}
