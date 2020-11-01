package com.ksptooi.flr.input.dispatch.adapter;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Method;
import java.util.HashMap;


/**
 * 分步命令适配器
 */
public class InternalBukkitStepInputAdapter implements StepInputAdapter{


    private HashMap<Method,Object> handler = new HashMap<Method, Object>();



    @Override
    public void findProcessor(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException {




    }


    @Override
    public Model assign(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException {
        throw new RuntimeException("不支持的适配器操作!");
    }



    @Override
    public void regHandler(Class handler) {
        if(handler.getAnnotation(Processor.class)==null){
            throw new RuntimeException("不支持的适配器操作!!");
        }

        try{


            Method[] declaredMethods = handler.getDeclaredMethods();

            for(Method m:declaredMethods){

                //没有CommandMapper注解的方法 直接进行下一个循环
                if(m.getAnnotation(ProcessMapper.class)==null){
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
        throw new RuntimeException("不支持的适配器操作!!");
    }

    @Override
    public void handlerScanner(String packet) {
        throw new RuntimeException("不支持的适配器操作!!");
    }


}
