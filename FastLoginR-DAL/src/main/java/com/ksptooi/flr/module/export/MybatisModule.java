package com.ksptooi.flr.module.export;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.c3p0.C3p0DataSourceProvider;
import org.mybatis.guice.datasource.druid.DruidDataSourceProvider;

import javax.sql.DataSource;
import java.util.Properties;

public class MybatisModule extends XMLMyBatisModule {


    public MybatisModule(){

    }



    protected void initialize() {

        setEnvironmentId("development");
        setClassPathResource("mybatis-mysql.xml");

    }

    private Properties createProperties(String configFile) {
        Properties result = new Properties();
        try {
            result.load(MybatisModule.class.getClassLoader().getResourceAsStream(configFile));
            return result;
        } catch (Exception e) {
            throw new RuntimeException("can not load " + configFile + " .", e);
        }
    }

    protected Properties getMybatisProperties(){
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "mybatis-guice_TEST");
        myBatisProperties.setProperty("derby.create", "true");
        myBatisProperties.setProperty("JDBC.username", "sa");
        myBatisProperties.setProperty("JDBC.password", "");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }



}
