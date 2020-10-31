package com.ksptooi.flr.input.command;


import com.google.inject.Inject;
import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.service.player.PlayerService;
import org.apache.ibatis.annotations.Param;
import org.bukkit.command.CommandSender;

@CommandHandler
public class PlayerCommandHandler {

    @Inject
    PlayerService service = null;


    //玩家登录方法
    @CommandMapper(value = "login",alias = {"l","log"})
    public boolean playerLogin(@Params("name")String name,
                               @Params("sender")CommandSender s,
                               @Params("params")String[] p){



        return false;
    }


    //玩家注册方法
    @CommandMapper("register")
    public boolean playerRegister(@Params("sender")CommandSender s,
                                  @Params("params")String[] p){



        return false;
    }


}
