package com.ksptooi.flr.proc.module.export;

import com.ksptooi.flr.dao.access.DatabaseType;
import org.mybatis.guice.XMLMyBatisModule;

public class NDALModule extends XMLMyBatisModule {


    private String dbType = DatabaseType.H2;

    private static NDALModule module = null;

    private static final String moduleName = "Data-Access-Layer-Module";

    private NDALModule(){}

    private NDALModule(String dataBaseType){
        this.dbType = dataBaseType;
    }


    /**
     * 初始化模块
     * @return
     */
    public static NDALModule getModule() {

        if(module!=null){
            return module;
        }

        //初始化模块
        module = new NDALModule();
        System.out.println("[FastLoginR] Install Module "+moduleName+" Done!");
        return module;
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
