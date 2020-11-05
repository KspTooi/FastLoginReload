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
import com.ksptooi.flr.proc.aop.service.ServiceExceptionAOP;
import com.ksptooi.flr.proc.service.player.PlayerService;
import com.ksptooi.flr.proc.service.player.PlayerServiceBlock;
import com.ksptooi.flr.proc.service.player.PlayerStateService;
import com.ksptooi.flr.proc.service.player.PlayerStateServiceBlock;
import com.ksptooi.flr.sec.module.export.SecurityModule;

public class ProcModule extends AbstractModule {

    private static Injector inject = null;

    private static final String moduleName = "Proc-Module";

    private static ProcModule module = null;

    @Override
    protected void configure() {

        bind(PlayerService.class).to(PlayerServiceBlock.class).in(Scopes.SINGLETON);

        bind(PlayerStateService.class).to(PlayerStateServiceBlock.class).in(Scopes.SINGLETON);


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


    public static ProcModule getModule(){

        if(module!=null){
            return module;
        }

        module = new ProcModule();
        System.out.println("[FastLoginR] Install Module "+moduleName+" Done!");
        
        return module;
    }



    public static Injector getInject(){

        if(inject != null){
            return inject;
        }


        //初始化inject
        Injector injector = Guice.createInjector(new ProcModule(),NDALModule.getModule(),new SecurityModule());
        inject = injector;
        return injector;
    }

}
