package com.ksptooi.easydev.dispatch.adapter;

import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.entity.status.ErrorStatus;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.aop.annotation.MethodJoinPoint;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.module.export.ProcModule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认的命令适配器 - 不支持包扫描机制仅提供命令的注册与分配
 */
public class DefaultInputAdapter implements InputAdapter {


    private HashMap<Method,Object> handler = new HashMap<Method, Object>();


    @Override
    @MethodJoinPoint
    public Model assign(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException {

        ArrayList<Object> invokeParameters = null;

        for(Map.Entry<Method,Object> e:handler.entrySet()){

            ProcessMapper mapper = e.getKey().getAnnotation(ProcessMapper.class);


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

                            //自动装配MODEL
                            if(param.value().equalsIgnoreCase("model")){
                                Model model = new Model(sender);
                                invokeParameters.add(model);
                            }

                        }

                    }

                }

                Model invokeResultModel = null;

                try {

                    //默认适配器切面
                    ProcModule.getInject().injectMembers(e.getValue());

                    invokeResultModel = (Model) e.getKey().invoke(e.getValue(), invokeParameters.toArray());

                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }

                return invokeResultModel;

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

        throw new NotFoundProcessorException(ErrorStatus.FATAL_NOT_FOUND_HANDLER);
    }


    @Override
    public void regHandler(Class handler) {


        if(handler.getAnnotation(Processor.class)==null){
            throw new RuntimeException("不支持的操作!");
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
        throw new RuntimeException("不支持的操作!");
    }

    @Override
    public void handlerScanner(String packet) {
        throw new RuntimeException("不支持的操作!");
    }

}
