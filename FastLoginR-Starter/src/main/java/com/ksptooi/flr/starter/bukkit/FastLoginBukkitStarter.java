package com.ksptooi.flr.starter.bukkit;

import com.google.inject.Injector;
import com.ksptooi.flr.input.dispatch.InputDispatch;
import com.ksptooi.flr.input.listener.PlayerStateListener;
import com.ksptooi.flr.input.processor.PlayerAccountProcessor;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.exception.ParamsLengthException;
import com.ksptooi.flr.proc.service.player.PlayerStateService;
import com.ksptooi.flr.sec.input.listener.PlayerJoinListener;
import com.ksptooi.flr.sec.task.PlayerKickTask;
import com.ksptooi.flr.sec.task.PlayerMsgTask;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;
import com.ksptooi.flr.starter.module.export.StarterModule;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class FastLoginBukkitStarter extends JavaPlugin {

    public static final String currentVersion = "1.5F.4";

    //public static final Injector injector= ProcModule.getInject();
    public static Injector injector = null;

    @Override
    public void onEnable() {

        injector = StarterModule.getInjector(this);


        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

        InputDispatch instance = injector.getInstance(InputDispatch.class);
        instance.regProcessor(PlayerAccountProcessor.class);

        PlayerStateListener playerStateListener = new PlayerStateListener(injector.getInstance(PlayerStateService.class));
        PlayerJoinListener playerJoinListener = new PlayerJoinListener(injector.getInstance(PlayerTaskQueueService.class));


        //注册监听器
        Bukkit.getPluginManager().registerEvents(playerStateListener,this);
        Bukkit.getPluginManager().registerEvents(playerJoinListener,this);



        //启动队列线程
        Thread playerMsgTh = new Thread(injector.getInstance(PlayerMsgTask.class));
        playerMsgTh.start();
        Thread playerCheckKickTh = new Thread(injector.getInstance(PlayerKickTask.class));
        playerCheckKickTh.start();


/*        InputAdapter instance = ProcModule.getInject().getInstance(InputAdapter.class);
        instance.regHandler(PlayerAccountProcessor.class);*/


/*        instance.assign("login",null,null,null,null);*/


/*        DalModule.install(DatabaseType.H2);

        Injector inject = DalModule.getInject();

        PlayerMapper instance1 = inject.getInstance(PlayerMapper.class);

        FLRPlayer playerById = instance1.getPlayerById(1);

        System.out.println(playerById);*/

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    //命令执行器
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        //获取到调度器
        InputDispatch instance = injector.getInstance(InputDispatch.class);

        boolean b = false;

        try {

            b = instance.dispatchInputCommand(cmd.getName(), sender, cmd, label, args);


        } catch (AdapterParameterException e) {
            e.printStackTrace();
        } catch (NotFoundProcessorException | ParamsLengthException e) {
            sender.sendMessage(e.getMsg());
        }


        return b;
    }



}
