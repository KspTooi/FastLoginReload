package com.ksptooi.flr.proc.module.export;


import com.google.inject.*;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.dao.access.MybatisSqliteAccess;

public class DalModule extends AbstractModule{


    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;


    public static void install(String dbType){
        DalModule.dbType = dbType;
        Injector injector = Guice.createInjector(new DalModule(), new MybatisModule(dbType));
        setInject(injector);
    }


    //IOC配置
    protected void configure() {
        bind(MybatisAccess.class).to(MybatisSqliteAccess.class).in(Scopes.SINGLETON);
    }


    public static Injector getInject() {

        if(inject == null){
            throw new RuntimeException("当前模块没有初始化!");
        }

        return inject;
    }

    public static void setInject(Injector inject) {
        DalModule.inject = inject;
    }

}
