package com.ksptooi.flr.starter;

import com.google.inject.Injector;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.dispatch.InputDispatch;
import com.ksptooi.flr.input.dispatch.adapter.InputAdapter;
import com.ksptooi.flr.input.processor.PlayerAccountProcessor;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.ParamsLengthException;
import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class FastLoginR extends JavaPlugin {

    public static final String currentVersion = "1.4F.89";

    public static final Injector injector= ProcModule.getInject();

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

        InputDispatch instance = injector.getInstance(InputDispatch.class);
        instance.regProcessor(PlayerAccountProcessor.class);


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

/*        //获取到适配器
        InputAdapter adapter = injector.getInstance(InputAdapter.class);

        Model model = null;

        try {

            model = adapter.assign(cmd.getName(), sender, cmd, label, args);

            if(model == null){
                sender.sendMessage("当前命令执行时出现内部错误,请联系管理员.");
                return false;
            }

        } catch (NotFoundProcessorException e) {
            sender.sendMessage("没有为该命令找到相应的处理器.");
            e.printStackTrace();
            return false;
        }*/


        /*return model.isFinish();*/
    }



}
