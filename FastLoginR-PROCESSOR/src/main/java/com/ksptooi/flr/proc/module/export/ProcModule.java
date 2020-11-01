package com.ksptooi.flr.proc.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.input.dispatch.adapter.InputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.DefaultInputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.InternalBukkitStepInputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.proc.aop.annotation.MethodJoinPoint;
import com.ksptooi.flr.proc.aop.service.InputAfterAOP;
import com.ksptooi.flr.proc.aop.service.ServiceExceptionAOP;
import com.ksptooi.flr.proc.service.player.PlayerService;
import com.ksptooi.flr.proc.service.player.PlayerServiceBlock;

public class ProcModule extends AbstractModule {

    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;

    @Override
    protected void configure() {

        bind(PlayerService.class).to(PlayerServiceBlock.class).in(Scopes.SINGLETON);
        bind(InputAdapter.class).to(DefaultInputAdapter.class).in(Scopes.SINGLETON);
        bind(StepInputAdapter.class).to(InternalBukkitStepInputAdapter.class).in(Scopes.SINGLETON);

        bindInterceptor(
                 Matchers.identicalTo(PlayerServiceBlock.class)
                ,Matchers.any()
                ,new ServiceExceptionAOP()
        );

        bindInterceptor(
                Matchers.any()
                ,Matchers.annotatedWith(MethodJoinPoint.class)
                ,new InputAfterAOP()
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
