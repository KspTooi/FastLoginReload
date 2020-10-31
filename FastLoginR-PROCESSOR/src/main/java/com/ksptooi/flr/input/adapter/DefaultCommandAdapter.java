package com.ksptooi.flr.input.adapter;

import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.module.export.ProcModule;
import com.ksptooi.flr.proc.aop.annotation.MethodJoinPoint;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认的命令适配器 - 不支持包扫描机制仅提供命令的注册与分配
 */
public class DefaultCommandAdapter implements CommandAdapter{


    private HashMap<Method,Object> handler = new HashMap<Method, Object>();


    @Override
    @MethodJoinPoint
    public boolean assign(String name, CommandSender sender, Command cmd,String label, String[] params) {

        ArrayList<Object> invokeParameters = null;

        for(Map.Entry<Method,Object> e:handler.entrySet()){

            CommandMapper mapper = e.getKey().getAnnotation(CommandMapper.class);


            //如果命令名与注解名相符 则将命令分配到该处理器
            if(name.equals(mapper.value())){

                //准备注入参数
                invokeParameters = new ArrayList<Object>();


                //解析参数注解
                for(Annotation[] parameterAnnotation:e.getKey().getParameterAnnotations()){

                    /*System.out.println(parameterAnnotation[0]);*/

                    for (Annotation annotation : parameterAnnotation) {

                        if (annotation instanceof Params) {
                            Params param = (Params) annotation;

                            if(param.value().equalsIgnoreCase("name")){
                                invokeParameters.add(name);
                            }

                            if(param.value().equalsIgnoreCase("sender")){
                                invokeParameters.add(sender);
                            }

                            if(param.value().equalsIgnoreCase("cmd")){
                                invokeParameters.add(cmd);
                            }

                            if(param.value().equalsIgnoreCase("params")){
                                invokeParameters.add(params);
                            }

                            if(param.value().equalsIgnoreCase("label")){
                                invokeParameters.add(label);
                            }

                        }

                    }

                }


                //默认适配器切面
                ProcModule.getInject().injectMembers(e.getValue());

                boolean b= false;

                try {


                    b = (boolean)e.getKey().invoke(e.getValue(),invokeParameters.toArray());


                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }

                return b;

/*                try{

                    *//*System.out.println(invokeParameters.toArray());*//*

                    ProcModule.getInject().injectMembers(e.getValue());

                    boolean b=(boolean)e.getKey().invoke(e.getValue(),invokeParameters.toArray());

                    return b;

                }catch (Exception exception){
                    exception.printStackTrace();
                    System.out.println("严重错误,分配处理器时发生异常. 可能是处理器没有成功处理该命令.");
                }*/

            }

        }

        return false;
    }


    @Override
    public void regHandler(Class handler) {


        if(handler.getAnnotation(CommandHandler.class)==null){
            throw new RuntimeException("不支持的操作!");
        }

        try{


            Method[] declaredMethods = handler.getDeclaredMethods();

            for(Method m:declaredMethods){

                //没有CommandMapper注解的方法 直接进行下一个循环
                if(m.getAnnotation(CommandMapper.class)==null){
                    continue;
                }

                this.handler.put(m,handler.newInstance());
                /*System.out.println("已加载:"+handler);*/
            }



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("加载命令处理器时出错!");
        }



    }



    @Override
    public void regHandler(String path) {
        throw new RuntimeException("不支持的操作!");
    }

    @Override
    public void handlerScanner(String packet) {
        throw new RuntimeException("不支持的操作!");
    }

}
