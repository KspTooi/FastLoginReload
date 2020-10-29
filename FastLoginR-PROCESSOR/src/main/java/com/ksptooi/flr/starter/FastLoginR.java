package com.ksptooi.flr.starter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.MybatisAccess;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.module.export.DalModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class FastLoginR extends JavaPlugin {

    public static final String currentVersion = "1.3F.2";

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());


        Injector inject = DalModule.getInject();
        PlayerMapper instance1 = inject.getInstance(PlayerMapper.class);

        FLRPlayer playerById = instance1.getPlayerById(1);

        System.out.println(playerById);

/*        Injector injector = Guice.createInjector(new DalModule());
        MybatisAccess instance = injector.getInstance(MybatisAccess.class);
        System.out.println(instance);*/


/*        Injector injector = Guice.createInjector();
        PlayerService instance = injector.getInstance(PlayerService.class);
        System.out.println(injector);*/

/*        Thread th = new Thread(new HibernateStarter());
        th.start();*/


        /*PlayerService playerService = ContextR.get(PlayerService.class);*/



/*        logger.info("[FastLoginR]"+playerService);
        playerService.playerRegister(null);*/

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
