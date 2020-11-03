package com.ksptooi.flr.input.dispatch.resolver;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.proc.exception.ServiceException;

import java.util.ArrayList;

public class BasicModelResolver implements InputResultResolver{



    @Override
    public boolean ResolverModel(Model model,ServiceException serviceException) {

        //如果发生异常则交给异常处理器执行
        if(serviceException!=null){
            this.resolverException(model,serviceException);
            return false;
        }


        //MODEL解析 发送消息
        ArrayList<String> message = model.getMessage();

        for(String str:message){
            model.getSender().sendMessage(str);
        }

        return true;
    }


    /**
     * 异常处理器
     * @param model
     * @param serviceException
     */
    public void resolverException(Model model,ServiceException serviceException) {
        model.getSender().sendMessage(serviceException.getMsg());
    }


}
