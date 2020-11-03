package com.ksptooi.flr.input.dispatch.resolver;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.proc.exception.ServiceException;

import java.util.ArrayList;

public class BasicModelResolver implements InputResultResolver{



    @Override
    public boolean ResolverModel(Model model,ServiceException serviceException) {


        //MODEL解析 发送消息
        ArrayList<String> message = model.getMessage();

        for(String str:message){
            model.getSender().sendMessage(str);
        }

        return true;
    }





}
