package com.ksptooi.flr.input.command;

import com.google.inject.Inject;
import com.ksptooi.flr.dao.exception.DBException;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.PlayerOnly;
import com.ksptooi.flr.proc.exception.AuthException;
import com.ksptooi.flr.service.player.PlayerService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandHandler
public class PlayerCommandHandler {

    @Inject
    PlayerService service = null;

    /**
     * 用于玩家登录
     * @param sender
     * @param p
     * @return 成功返回true 失败返回false
     */
    @PlayerOnly
    @CommandMapper(value = "login",alias = {"l","log"})
    public boolean playerLogin(@Params("sender")CommandSender sender,
                               @Params("params")String[] p){

        Player pl = (Player) sender;

        //边界检查
        if(p.length<1){
            sender.sendMessage("请输入密码!");
            return false;
        }

        try{


            FLRPlayer player = service.playerLogin(pl.getName(), p[0]);
            sender.sendMessage("登录成功!");

            return true;


        }catch (AuthException authException){
            sender.sendMessage(authException.getMsg());
            return false;
        }catch (DBException dbException){
            sender.sendMessage("错误");
            return false;
        }


    }


    /**
     * 用于玩家注册
     * @param sender
     * @param para
     * @return
     */
    @PlayerOnly
    @CommandMapper("register")
    public boolean playerRegister(@Params("sender")CommandSender sender,
                                  @Params("params")String[] para){

        //边界检查
        if(para.length<2){
            sender.sendMessage("注册失败,格式:/register 密码 确认密码!");
            return false;
        }

        FLRPlayer flrPlayer = new FLRPlayer();
        flrPlayer.setAccount(sender.getName());
        flrPlayer.setPassword(para[0]);


        try{


            FLRPlayer regPlayer = service.playerRegister(flrPlayer);

            if(regPlayer!=null){
                sender.sendMessage("注册成功!");
            }


            return true;

        }catch (AuthException authException){
            sender.sendMessage(authException.getMsg());
            return false;
        }


    }


}
