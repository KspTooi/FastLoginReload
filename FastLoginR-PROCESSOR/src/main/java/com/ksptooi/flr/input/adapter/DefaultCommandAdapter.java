package com.ksptooi.flr.input.adapter;

import com.ksptooi.flr.input.annotation.CommandHandler;
import com.ksptooi.flr.input.annotation.CommandMapper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
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


    private ArrayList<Method> handlersMethod = new ArrayList<Method>();

    private HashMap<Method,Object> handler = new HashMap<Method, Object>();

    @Override
    public boolean assign(String name, CommandSender sender, Command cmd, String[] params) {


        for(Map.Entry<Method,Object> e:handler.entrySet()){

            CommandMapper mapper = e.getKey().getAnnotation(CommandMapper.class);


            //如果命令名与注解名相符 则将命令分配到该处理器
            if(name.equals(mapper.value())){

                try{

                    boolean b=(boolean)e.getKey().invoke(e.getValue(),"aaaa");

                    System.out.println("执行完成:"+b);

                }catch (Exception exception){
                    exception.printStackTrace();
                    System.out.println("适配器分配命令时出现错误!");
                }

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
                System.out.println("已加载:"+handler);
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
