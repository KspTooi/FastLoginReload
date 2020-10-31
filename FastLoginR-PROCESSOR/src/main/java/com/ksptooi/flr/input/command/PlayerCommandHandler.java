package com.ksptooi.flr.input.command;

import com.google.inject.Inject;
import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.PlayerOnly;
import com.ksptooi.flr.service.player.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandHandler
public class PlayerCommandHandler {

    @Inject
    PlayerService service = null;

    /**
     * 用于玩家登录
     * @param name
     * @param sender
     * @param p
     * @param c
     * @return 成功返回true 失败返回false
     */
    @PlayerOnly
    @CommandMapper(value = "login",alias = {"l","log"})
    public boolean playerLogin(@Params("name")String name,
                               @Params("sender")CommandSender sender,
                               @Params("params")String[] p,
                               @Params("cmd") Command c){

        sender.sendMessage("命令名:"+name);
        sender.sendMessage("命令参数:"+p.toString());

        return true;
    }


    /**
     * 用于玩家注册
     * @param s
     * @param p
     * @return
     */
    @PlayerOnly
    @CommandMapper("register")
    public boolean playerRegister(@Params("sender")CommandSender s,
                                  @Params("params")String[] p){



        return false;
    }


}
