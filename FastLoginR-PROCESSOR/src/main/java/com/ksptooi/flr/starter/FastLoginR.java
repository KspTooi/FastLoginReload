package com.ksptooi.flr.starter;

import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.input.adapter.CommandAdapter;
import com.ksptooi.flr.input.command.PlayerCommandHandler;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.module.export.DalModule;
import com.ksptooi.flr.module.export.ProcModule;
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

    public static final String currentVersion = "1.3F.104";
    


    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        /*Thread.currentThread().setContextClassLoader(getClass().getClassLoader());*/

        CommandAdapter instance = ProcModule.getInject().getInstance(CommandAdapter.class);

        instance.regHandler(PlayerCommandHandler.class);
        instance.assign("login",null,null,null);


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



        return false;
    }



}
