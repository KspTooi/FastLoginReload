package com.ksptooi.easydev.dispatch.resolver;


import com.ksptooi.easydev.entity.Model;
import com.ksptooi.easydev.exceptions.ServiceException;

import java.util.ArrayList;

public class BasicModelResolver implements InputResultResolver {



    @Override
    public boolean ResolverModel(Model model, ServiceException serviceException) {


        //MODEL解析 发送消息
        ArrayList<String> message = model.getMessage();

        for(String str:message){
            model.getSender().sendMessage(str);
        }

        return true;
    }





}
