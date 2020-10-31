package com.ksptooi.flr.input.adapter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.lang.reflect.InvocationTargetException;

/**
 * 命令适配器 用于和命令处理器配合使用
 *
 * 命令执行流程 Bukkit->CommandAdapter->CommandHandler
 *
 */
public interface CommandAdapter {

    /**
     * 分配命令至命令处理器
     * @param name
     * @param sender
     * @param cmd
     * @param params
     * @return 成功返回true 失败返回false
     */
    boolean assign(String name, CommandSender sender, Command cmd,String label, String[] params);

    /**
     * 注册命令处理器
     * @param handler 执行器类名
     */
    void regHandler(Class handler);


    /**
     * 注册命令处理器
     * @param path 执行器类路径
     */
    void regHandler(String path);

    /**
     * 扫描某个包下所有的命令执行器(需要注解@CommandHandler)
     * @param packet 执行器包路径
     */
    void handlerScanner(String packet);
}
