package com.ksptooi.flr.proc.module.export;


import com.google.inject.*;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.dao.access.MybatisSqliteAccess;

public class DalModule extends AbstractModule{


    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;

    private static final String moduleName = "DataAccessLayer";


    //IOC配置
    protected void configure() {
        //bind(MybatisAccess.class).to(MybatisSqliteAccess.class).in(Scopes.SINGLETON);
    }


    public static Injector getInject() {

        System.out.println("[FastLoginR]Module-"+moduleName+" Install Done(Injector)");

        if(inject != null){
            return inject;
        }

        //初始化inject
        Injector injector = Guice.createInjector(new NDALModule(dbType));
        inject = injector;
        return injector;
    }

    public static String getDbType() {
        return dbType;
    }

    public static void setDbType(String dbType) {
        DalModule.dbType = dbType;
    }

    public static String getModuleName() {
        return moduleName;
    }
}

