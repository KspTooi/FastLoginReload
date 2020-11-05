package com.ksptooi.flr.sec.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.proc.module.export.DalModule;
import com.ksptooi.flr.proc.module.export.NDALModule;
import com.ksptooi.flr.sec.queue.PlayerKickTask;
import com.ksptooi.flr.sec.queue.PlayerMsgTask;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;
import com.ksptooi.flr.sec.service.PlayerTaskQueueServiceBlock;

public class SecurityModule extends AbstractModule {

    private static Injector inject = null;

    private static SecurityModule module = null;

    private static final String moduleName = "Security-Module";

    private SecurityModule(){

    }

    @Override
    protected void configure() {

        //玩家消息任务定时器
        bind(PlayerMsgTask.class).in(Scopes.SINGLETON);

        //玩家踢出任务定时器
        bind(PlayerKickTask.class).in(Scopes.SINGLETON);

        //玩家任务定时器服务
        bind(PlayerTaskQueueService.class).to(PlayerTaskQueueServiceBlock.class).in(Scopes.SINGLETON);

    }

    public static Injector getInject(){

        if(inject!=null){
            return inject;
        }

        inject = Guice.createInjector(NDALModule.getModule(),SecurityModule.getModule());
        return inject;
    }


    public static SecurityModule getModule(){

        if(module!=null){
            return module;
        }

        module = new SecurityModule();
        System.out.println("[FastLoginR] Install Module "+moduleName+" Done!");
        return module;
    }



}
