package com.ksptooi.flr.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.service.player.PlayerService;
import com.ksptooi.flr.service.player.PlayerServiceBlock;

public class ProcModule extends AbstractModule {

    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;

    @Override
    protected void configure() {
        bind(PlayerService.class).to(PlayerServiceBlock.class);
    }


    //设置数据库的类型
    public static void setDatabaseType(String typeString){
        dbType = typeString;
    }


    public static Injector getInject(){

        if(inject != null){
            return inject;
        }

        //初始化inject
        Injector injector = Guice.createInjector(new ProcModule(), new DalModule(), new MybatisModule(dbType));
        inject = injector;
        return injector;
    }

}
