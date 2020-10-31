package com.ksptooi.flr.starter;

import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.entity.model.InputModel;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.input.adapter.CommandAdapter;
import com.ksptooi.flr.input.command.PlayerCommandHandler;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.module.export.DalModule;
import com.ksptooi.flr.module.export.ProcModule;
import com.ksptooi.flr.proc.exception.NotFoundHandlerException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Logger;

public class FastLoginR extends JavaPlugin {

    public static final String currentVersion = "1.4F.19";

    public static final Injector injector= ProcModule.getInject();

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        /*Thread.currentThread().setContextClassLoader(getClass().getClassLoader());*/

        CommandAdapter instance = ProcModule.getInject().getInstance(CommandAdapter.class);

        instance.regHandler(PlayerCommandHandler.class);
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

        //获取到适配器
        CommandAdapter adapter = injector.getInstance(CommandAdapter.class);

        InputModel model = null;

        try {

            model = adapter.assign(cmd.getName(), sender, cmd, label, args);

            if(model == null){
                sender.sendMessage("当前命令执行时出现内部错误,请联系管理员.");
                return false;
            }

        } catch (NotFoundHandlerException e) {
            sender.sendMessage("没有为该命令找到相应的处理器.");
            e.printStackTrace();
            return false;
        }


        return model.isFinish();
    }



}
