package com.ksptooi.flr.input.processor;

import com.google.inject.Inject;
import com.ksptooi.flr.dao.exception.DBException;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.input.annotation.*;
import com.ksptooi.flr.proc.exception.AuthException;
import com.ksptooi.flr.proc.service.player.PlayerService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Processor
public class PlayerAccountProcessor {


    @Inject
    PlayerService service = null;


    /**
     * 用于玩家登录
     * @param sender
     * @param p
     * @return 成功返回true 失败返回false
     */
    @PlayerOnly
    @Check(value = "请输入密码",length = 1)
    @ProcessMapper(value = "login",alias = {"l","log"})
    public Model playerLogin(@Params("sender")CommandSender sender
                            ,@Params("params")String[] p
                            ,@Params("model") Model model) {


        Player pl = (Player) sender;

        try{


            FLRPlayer player = service.playerLogin(pl.getName(), p[0]);
            model.addMessage("登录成功!");
            model.finish();
            return model;


        }catch (DBException dbException){
            model.addMessage("严重错误-数据库异常!");
            dbException.printStackTrace();

        }catch (AuthException authException){
            model.addMessage(authException.getMsg());
        }


        return model;

    }


    /**
     * 用于玩家注册
     * @param sender
     * @param para
     * @return
     */
    @PlayerOnly
    @Check(value = "注册失败,格式:/register 密码 确认密码!",length = 2)
    @ProcessMapper("register")
    public Model playerRegister(@Params("sender")CommandSender sender,
                                @Params("params")String[] para){

        Model model = new Model(sender);


        FLRPlayer flrPlayer = new FLRPlayer();
        flrPlayer.setAccount(sender.getName());
        flrPlayer.setPassword(para[0]);


        try{


            FLRPlayer regPlayer = service.playerRegister(flrPlayer);

            if(regPlayer!=null){
                model.addMessage("注册成功!");
                model.setFinish(true);
                return model;
            }




        }catch (DBException dbException){
            model.addMessage("严重错误-数据库异常!");
            dbException.printStackTrace();

        }catch (AuthException e){
            model.addMessage(e.getMsg());
            return model;
        }


        return model;
    }


}
