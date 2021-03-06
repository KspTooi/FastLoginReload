package com.ksptooi.flr.input.dispatch.adapter;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * 命令适配器 用于和命令处理器配合使用
 *
 * 命令执行流程 Bukkit->CommandAdapter->CommandHandler
 *
 */
public interface InputAdapter {

    /**
     * 分配命令至命令处理器
     * @param name
     * @param sender
     * @param cmd
     * @param params
     * @return 成功返回true 失败返回false
     */
    Model assign(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException;

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
