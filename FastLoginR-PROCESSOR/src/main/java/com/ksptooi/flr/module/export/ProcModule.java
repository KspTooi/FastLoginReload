package com.ksptooi.flr.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.input.adapter.CommandAdapter;
import com.ksptooi.flr.input.adapter.DefaultCommandAdapter;
import com.ksptooi.flr.input.command.PlayerCommandHandler;
import com.ksptooi.flr.proc.aop.annotation.MethodJoinPoint;
import com.ksptooi.flr.proc.aop.service.InputExceptionAOP;
import com.ksptooi.flr.proc.aop.service.ServiceExceptionAOP;
import com.ksptooi.flr.service.player.PlayerService;
import com.ksptooi.flr.service.player.PlayerServiceBlock;

public class ProcModule extends AbstractModule {

    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;

    @Override
    protected void configure() {

        bind(PlayerService.class).to(PlayerServiceBlock.class).in(Scopes.SINGLETON);
        bind(CommandAdapter.class).to(DefaultCommandAdapter.class).in(Scopes.SINGLETON);

        bindInterceptor(
                 Matchers.identicalTo(PlayerServiceBlock.class)
                ,Matchers.any()
                ,new ServiceExceptionAOP()
        );

        bindInterceptor(
                Matchers.any()
                ,Matchers.annotatedWith(MethodJoinPoint.class)
                ,new InputExceptionAOP()
        );

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
