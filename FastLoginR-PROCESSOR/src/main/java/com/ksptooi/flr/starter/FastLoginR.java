package com.ksptooi.flr.starter;

import com.google.inject.Injector;
import com.ksptooi.flr.dao.access.DatabaseType;
import com.ksptooi.flr.entity.player.FLRPlayer;
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

    public static final String currentVersion = "1.3F.95";

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();
        logger.info("[FastLoginR]版本:"+currentVersion);
        logger.info("[FastLoginR]尝试注入Services:");
        logger.info("[FastLoginR]");

        /*Thread.currentThread().setContextClassLoader(getClass().getClassLoader());*/

        try {

            scanner("com.ksptooi.flr.input.command");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


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
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        return false;
    }


    public static void scanner(String pack) throws IOException, ClassNotFoundException {

        System.out.println(pack);
        String packageDirName = pack.replace('.', '/');



        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        System.out.println(dirs);



        for (; dirs.hasMoreElements(); ) {

            // 获取下一个元素
            URL url = dirs.nextElement();

            // 得到协议的名称
            String protocol = url.getProtocol();


            if (protocol.equals("file")) {
                // 获取包的物理路径
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");

                // 以文件的方式扫描整个包下的文件 并添加到集合中
                File dir = new File(filePath);
                File[] files = dir.listFiles();


                for (File f : files) {

                    //是class文件
                    if (f.getName().endsWith(".class")) {

                        String replace = f.getName().replace(".class", "");

                        System.out.println(replace);

                        Class clazz = Class.forName(pack + "." + replace);

                    }

                }

            }

            if (protocol.equals("jar")) {
                throw new RuntimeException("扫描包时发生错误! 协议不支持JAR.");
            }

        }
    }

}
