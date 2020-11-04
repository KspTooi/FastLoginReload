package com.ksptooi.flr.proc.aop.unit;

import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.flr.proc.service.player.PlayerService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;


public class AopUnit implements MethodInterceptor {



    @Test
    public void AOP(){

        PlayerService instance = ProcModule.getInject().getInstance(PlayerService.class);

        instance.serviceMethod();

    }


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //代码执行前
        System.out.println("Before " + invocation.getMethod().getName());

        //执行原来的代码
        Object result = invocation.proceed();

        //代码执行后
        System.out.println("After " + invocation.getMethod().getName());


        //修改代码返回值
        return result;
    }


}
