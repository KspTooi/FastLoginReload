package com.ksptooi.flr.input.processor;

import com.google.inject.Inject;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.service.admin.AdminService;

@Processor
public class AdminAccountProcessor {



    //管理员重置玩家密码
    @Inject
    AdminService service = null;



//    @ProcessMapper(value = "changepassword")
//    public Model adminChangePlayerPassword(){
//
//    }



}
