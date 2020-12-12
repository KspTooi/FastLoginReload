package com.ksptooi.flr.sec.module.export;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.ksptooi.flr.proc.module.export.NDALModule;
import com.ksptooi.flr.sec.task.daemon.PlayerKickTaskDaemon;
import com.ksptooi.flr.sec.task.daemon.PlayerMsgTaskDaemon;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;
import com.ksptooi.flr.sec.service.PlayerTaskQueueServiceBlock;
import org.bukkit.plugin.java.JavaPlugin;

public class SecurityModule extends AbstractModule {

    private static Injector inject = null;

    private static SecurityModule module = null;

    private static final String moduleName = "Security-Module";

    private static JavaPlugin plugin = null;

    private SecurityModule(){

    }

    @Override
    protected void configure() {

        //玩家消息任务定时器
        bind(PlayerMsgTaskDaemon.class).in(Scopes.SINGLETON);

        //玩家踢出任务定时器
        bind(PlayerKickTaskDaemon.class).in(Scopes.SINGLETON);

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

    public static SecurityModule getModule(JavaPlugin plugins){
        setPlugin(plugins);
        return getModule();
    }

    public static SecurityModule getModule(){

        if(module!=null){
            return module;
        }

        module = new SecurityModule();
        System.out.println("[FastLoginR] Install Module "+moduleName+" Done!");
        return module;
    }


    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(JavaPlugin plugin) {
        SecurityModule.plugin = plugin;
    }
}
