package com.ksptooi.flr.proc.module.export;

import com.google.inject.*;
import com.google.inject.matcher.Matchers;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.input.dispatch.BasicDispatch;
import com.ksptooi.flr.input.dispatch.InputDispatch;
import com.ksptooi.flr.input.dispatch.adapter.InputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.DefaultInputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.InternalBukkitStepInputAdapter;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.input.dispatch.resolver.BasicModelResolver;
import com.ksptooi.flr.input.dispatch.resolver.InputResultResolver;
import com.ksptooi.flr.input.listener.PlayerStateListener;
import com.ksptooi.flr.proc.aop.service.ServiceExceptionAOP;
import com.ksptooi.flr.proc.service.player.PlayerService;
import com.ksptooi.flr.proc.service.player.PlayerServiceBlock;

public class ProcModule extends AbstractModule {

    private static Injector inject = null;

    private static String dbType = DatabaseType.H2;

    @Override
    protected void configure() {

        bind(PlayerService.class).to(PlayerServiceBlock.class).in(Scopes.SINGLETON);

        bind(PlayerStateListener.class).in(Scopes.SINGLETON);


        //旧版适配器
        bind(InputAdapter.class).to(DefaultInputAdapter.class).in(Scopes.SINGLETON);

        //调度器
        bind(InputDispatch.class).to(BasicDispatch.class).in(Scopes.SINGLETON);

        //适配器
        bind(StepInputAdapter.class).to(InternalBukkitStepInputAdapter.class).in(Scopes.SINGLETON);

        //解析器
        bind(InputResultResolver.class).to(BasicModelResolver.class).in(Scopes.SINGLETON);

        bindInterceptor(
                 Matchers.identicalTo(PlayerServiceBlock.class)
                ,Matchers.any()
                ,new ServiceExceptionAOP()
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
