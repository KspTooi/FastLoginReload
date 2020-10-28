package com.ksptooi.flr.module.export;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.dao.access.MybatisSqliteAccess;

public class DalModule extends AbstractModule{


    private static Injector inject = null;

    static {
        Injector injector = Guice.createInjector(new DalModule(), new MybatisModule());
        setInject(injector);
    }



    //IOC配置
    protected void configure() {
        bind(MybatisAccess.class).to(MybatisSqliteAccess.class);
    }




    public static Injector getInject() {
        return inject;
    }

    public static void setInject(Injector inject) {
        DalModule.inject = inject;
    }
}
