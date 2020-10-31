package com.ksptooi.flr.module.export;

import com.ksptooi.flr.dao.access.DatabaseType;
import org.mybatis.guice.XMLMyBatisModule;

public class MybatisModule extends XMLMyBatisModule {


    private String dbType = DatabaseType.SQLITE;

    public MybatisModule(){}

    public MybatisModule(String dataBaseType){
        this.dbType = dataBaseType;
    }


    protected void initialize() {

        setEnvironmentId("development");

        if(dbType.equals(DatabaseType.MYSQL)){
            setClassPathResource("mybatis-mysql.xml");
            return;
        }

        if(dbType.equals(DatabaseType.SQLITE)){
            setClassPathResource("mybatis-sqlite.xml");
            return;
        }

        if(dbType.equals(DatabaseType.H2)){
            setClassPathResource("mybatis-h2.xml");
            return;
        }

        throw new RuntimeException("无效的DatabaseType!");
    }



}
