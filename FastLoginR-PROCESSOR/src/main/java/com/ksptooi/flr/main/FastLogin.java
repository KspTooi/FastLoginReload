package com.ksptooi.flr.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class FastLogin extends JavaPlugin {

    public static final String currentVersion = "0.5_A";

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLogin]正在初始化");

        Bukkit.getLogger().info("FastLogin init");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
