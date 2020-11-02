package com.ksptooi.flr.input.dispatch.resolver;

import com.ksptooi.flr.entity.model.Model;

import java.util.ArrayList;

public class DefaultBukkitCommandResultResolver implements InputResultResolver{



    @Override
    public boolean ResolverModel(Model model) {

        //MODEL解析 发送消息
        ArrayList<String> message = model.getMessage();

        for(String str:message){
            model.getSender().sendMessage(str);
        }

        return true;
    }


}
