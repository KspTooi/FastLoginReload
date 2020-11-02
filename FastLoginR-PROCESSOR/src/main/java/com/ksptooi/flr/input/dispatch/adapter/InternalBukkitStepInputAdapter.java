package com.ksptooi.flr.input.dispatch.adapter;

import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Params;
import com.ksptooi.flr.input.annotation.ProcessMapper;
import com.ksptooi.flr.input.annotation.Processor;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.module.export.ProcModule;
import com.ksptooi.util.dictionary.Excep;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 分步命令适配器
 */
public class InternalBukkitStepInputAdapter implements StepInputAdapter {

    private HashMap<Method, Object> handler = new HashMap<Method, Object>();


    @Override
    public InputProcessor findProcessor(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException, AdapterParameterException {


        ArrayList<Object> invokeParameters = null;

        HashMap<Method, Object> processClassByMapper = findProcessClassByMapper(handler, name);

        //如果有类注解符合要求 则判断方法命令名
        if (!(processClassByMapper.size() < 1)) {

            //如果子命令没有参数则直接抛出异常
            if (params == null || params.length < 1) {
                throw new AdapterParameterException(Excep.NOT_SUB_PARAMETER);
            }

            //找类下面的方法
            InputProcessor inputProcessor = findProcessMethodByMapper(processClassByMapper, params[0],false);

            //如果没有该子命令方法则直接抛出异常
            if (inputProcessor == null) {
                throw new NotFoundProcessorException(Excep.NOT_FOUND_SUB_PROCESSOR);
            }


            return install(inputProcessor, name, sender, cmd, label, params);
        }

        //如果没有类注解符合要求则直接遍历所有方法的注解
        return install(findProcessMethodByMapper(handler, name,true), name, sender, cmd, label, params);
    }


    //根据Processor方法注解准备参数
    public InputProcessor install(InputProcessor inputProcessor, String name, CommandSender sender, Command cmd, String label, String[] params) {

        ArrayList<Object> invokeParameters = new ArrayList<Object>();

        //解析参数注解
        for (Annotation[] parameterAnnotation : inputProcessor.getJoinPointMethod().getParameterAnnotations()) {


            for (Annotation annotation : parameterAnnotation) {

                if (annotation instanceof Params) {
                    Params param = (Params) annotation;

                    if (param.value().equalsIgnoreCase("name")) {
                        invokeParameters.add(name);
                    }

                    if (param.value().equalsIgnoreCase("sender")) {
                        invokeParameters.add(sender);
                    }

                    if (param.value().equalsIgnoreCase("cmd")) {
                        invokeParameters.add(cmd);
                    }

                    if (param.value().equalsIgnoreCase("params")) {
                        invokeParameters.add(params);
                    }

                    if (param.value().equalsIgnoreCase("label")) {
                        invokeParameters.add(label);
                    }

                    //自动装配MODEL
                    if (param.value().equalsIgnoreCase("model")) {
                        Model model = new Model(sender);
                        invokeParameters.add(model);
                    }

                }

            }

        }

        //注入参数
        inputProcessor.setInputParameters(invokeParameters);

        //注入服务
        ProcModule.getInject().injectMembers(inputProcessor.getClassInstance());

        return inputProcessor;

    }





    //根据ProcessMapper查找所有符合要求的处理器
    public InputProcessor findProcessMethodByMapper(HashMap<Method,Object> search,String mapperName,boolean skipClass) throws NotFoundProcessorException {

        for(Map.Entry<Method,Object> e:search.entrySet()){


            if(skipClass){
                //如果方法的类上面有注解值 则跳过
                if(e.getValue().getClass().getAnnotation(ProcessMapper.class)!=null){
                    continue;
                }
            }


            ProcessMapper methodAnnotation = e.getKey().getAnnotation(ProcessMapper.class);

            if(methodAnnotation == null){
                continue;
            }

            if(methodAnnotation.value().equals(mapperName)){
                return new InputProcessor(e.getKey(),e.getValue());
            }


        }

        throw new NotFoundProcessorException(Excep.FATAL_NOT_FOUND_HANDLER);
        /*return null;*/
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
