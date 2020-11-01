package com.ksptooi.flr.input.processor;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.exception.ServiceException;
import com.ksptooi.flr.proc.service.admin.AdminService;
import org.bukkit.command.CommandSender;

@Processor
@ProcessMapper("flr")
public class AdminAccountProcessor {


    //管理员重置玩家密码
    @Inject
    AdminService service = null;


    @ProcessMapper(value = "changepassword")
    public Model adminChangePlayerPassword(
             @Params("sender") CommandSender sender
            ,@Params("params")String[] p
            ,@Params("model") Model model)
    {

        if(p.length<3){
            model.addMessage("命令正确格式为: /flr changepassword 玩家名 新密码");
            return model;
        }

        try{


            if (service.resetPlayerPwd(p[1],p[2]) == null){
                model.addMessage("玩家不存在!");
                model.finish();
                return model;
            }


        }catch (ServiceException dbException){
            model.addMessage("严重错误-数据库异常!");
            dbException.printStackTrace();

        }

        return null;
    }





}
