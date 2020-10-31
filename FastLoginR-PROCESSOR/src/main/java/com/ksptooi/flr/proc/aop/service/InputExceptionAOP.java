package com.ksptooi.flr.proc.aop.service;


import com.ksptooi.flr.dao.exception.DBException;
import com.ksptooi.flr.proc.exception.AuthException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 适配器上层切面.
 */

public class InputExceptionAOP implements MethodInterceptor {

    /**
     * 切面方法
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {


        System.out.println("Input切面");

        //切面返回值
        Object result = null;


        try{

            //原切面方法
            result = invocation.proceed();

        }catch (RuntimeException e){
            throw new DBException();

        }catch (AuthException authException){
            throw authException;
        }


        return result;
    }

}
