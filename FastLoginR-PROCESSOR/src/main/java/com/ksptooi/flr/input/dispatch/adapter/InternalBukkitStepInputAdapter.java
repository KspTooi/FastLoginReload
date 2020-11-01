package com.ksptooi.flr.input.dispatch.adapter;

import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.util.dictionary.Excep;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 分步命令适配器
 */
public class InternalBukkitStepInputAdapter implements StepInputAdapter{


    private HashMap<Method,Object> handler = new HashMap<Method, Object>();



    @Override
    public InputProcessor findProcessor(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException, AdapterParameterException {


        ArrayList<Object> invokeParameters = null;

        HashMap<Method, Object> processClassByMapper = findProcessClassByMapper(handler,name);

        //如果有类注解符合要求 则判断方法命令名
        if(!(processClassByMapper.size()<1)){

            //如果子命令没有参数则直接抛出异常
            if(params==null||params.length<1){
                throw new AdapterParameterException(Excep.NOT_SUB_PARAMETER);
            }

            //找类下面的方法
            InputProcessor inputProcessor = findProcessMethodByMapper(processClassByMapper, params[0]);

            //如果没有该子命令方法则直接抛出异常
            if(inputProcessor==null){
                throw new NotFoundProcessorException(Excep.NOT_FOUND_SUB_PROCESSOR);
            }

            return inputProcessor;
        }

        //如果没有类注解符合要求则直接遍历所有方法的注解
        InputProcessor processMethodByMapper = findProcessMethodByMapper(handler, name);



        return processMethodByMapper;
    }



    //根据ProcessMapper查找所有符合要求的处理器
    public InputProcessor findProcessMethodByMapper(HashMap<Method,Object> search,String mapperName){

        for(Map.Entry<Method,Object> e:search.entrySet()){

            ProcessMapper methodAnnotation = e.getKey().getAnnotation(ProcessMapper.class);

            if(methodAnnotation == null){
                continue;
            }

            if(methodAnnotation.value().equals(mapperName)){
                return new InputProcessor(e.getKey(),e.getValue());
            }


        }


        return null;
    }




    //根据ProcessMapper查找所有符合要求的处理器[类]
    public HashMap<Method,Object> findProcessClassByMapper(HashMap<Method,Object> search,String mapperName){

        HashMap<Method,Object> result = new HashMap<Method,Object>();

        for(Map.Entry<Method,Object> e:search.entrySet()){

            ProcessMapper classAnnotation = e.getValue().getClass().getAnnotation(ProcessMapper.class);

            if(classAnnotation==null){
                continue;
            }

            if(classAnnotation.value().equalsIgnoreCase(mapperName)){
                result.put(e.getKey(),e.getValue());
            }

        }


        return result;
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
