package com.ksptooi.flr.entity.input.proc;

import com.ksptooi.flr.entity.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 输入处理器的包装类
 */
public class InputProcessor {

    //输入参数
    ArrayList<Object> inputParameters = null;

    //处理器方法的切入点
    Method joinPointMethod = null;

    //处理器类实例
    Object classInstance = null;


    //初始化
    public InputProcessor(Method joinPointMethod,Object classInstance,ArrayList<Object> inputParameters){
        this.inputParameters = inputParameters;
        this.joinPointMethod = joinPointMethod;
        this.classInstance = classInstance;
    }


    //执行处理器中的方法 并获得返回Model对象
    public Model run() throws InvocationTargetException, IllegalAccessException {

        Object invoke = joinPointMethod.invoke(classInstance, inputParameters.toArray());

        return invoke instanceof Model ? (Model)invoke : null;
    }


    //执行处理器中的方法 并获得返回Model对象 (不抛出异常)
    public Model start(){

        Object invoke = null;

        try{

            invoke = joinPointMethod.invoke(classInstance, inputParameters.toArray());

        }catch (InvocationTargetException | IllegalAccessException e){
           e.printStackTrace();
        }

        return invoke instanceof Model ? (Model)invoke : null;
    }


}
