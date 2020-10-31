package com.ksptooi.flr.input.command;


import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import com.ksptooi.flr.input.annotation.Params;
import org.apache.ibatis.annotations.Param;
import org.bukkit.command.CommandSender;

@CommandHandler
public class PlayerCommandHandler {


    //玩家登录方法
    @CommandMapper(value = "login",alias = {"l","log"})
    public boolean playerLogin(String s){

        System.out.println("123");


        return false;
    }



    //玩家注册方法
    @CommandMapper("register")
    public boolean playerRegister(String s){
        return false;
    }


}
