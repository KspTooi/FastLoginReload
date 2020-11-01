package com.ksptooi.flr.proc.aop.service;


import com.ksptooi.flr.entity.model.Model;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.ArrayList;

/**
 * Input层后处理异常切面
 */
public class InputAfterAOP implements MethodInterceptor {

    /**
     * 切面方法
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {


        System.out.println("Input切面");

        //切面返回值
        Model result = null;



        //原切面方法
        result = (Model) invocation.proceed();

        if(result==null){
            return null;
        }

        ArrayList<String> message = result.getMessage();

        for(String str:message){
            result.getSender().sendMessage(str);
        }


        return result;
    }

}
