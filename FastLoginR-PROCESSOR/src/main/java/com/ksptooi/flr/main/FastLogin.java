package com.ksptooi.flr.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class FastLogin extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getLogger().info("FastLogin init");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
