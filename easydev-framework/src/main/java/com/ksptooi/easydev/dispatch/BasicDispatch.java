package com.ksptooi.easydev.dispatch;

import com.google.inject.Inject;
import com.ksptooi.easydev.dispatch.adapter.StepInputAdapter;
import com.ksptooi.easydev.dispatch.resolver.InputResultResolver;
import com.ksptooi.easydev.entity.InputProcessor;
import com.ksptooi.easydev.entity.Model;
import com.ksptooi.easydev.exceptions.AdapterParameterException;
import com.ksptooi.easydev.exceptions.NotFoundProcessorException;
import com.ksptooi.easydev.exceptions.ParamsLengthException;
import com.ksptooi.easydev.exceptions.ServiceException;
import com.ksptooi.easydev.input.annotations.CheckLength;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BasicDispatch implements InputDispatch{

    @Inject
    StepInputAdapter stepInputAdapter = null;

    @Inject
    InputResultResolver inputResultResolver = null;


    @Override
    public boolean dispatchInputCommand(String name, CommandSender sender, Command cmd, String label, String[] params) throws AdapterParameterException, NotFoundProcessorException,ParamsLengthException {

        InputProcessor processor = null;

        Model model = null;
        ServiceException serviceException = null;

        processor = stepInputAdapter.findProcessor(name, sender, cmd, label, params);

        try{

            methodCheck(processor);
            model = processor.run();

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        if(model==null){
            return false;
        }


        return inputResultResolver.ResolverModel(model,serviceException);
    }


    private void methodCheck(InputProcessor processor)throws ParamsLengthException{

        Method joinPoint = processor.getJoinPointMethod();

        CheckLength annotation = joinPoint.getAnnotation(CheckLength.class);

        //没有使用Check检查
        if(annotation == null){
            return;
        }

        Class<?>[] parameterTypes = joinPoint.getParameterTypes();

        for(int i=0;i<joinPoint.getParameterCount();i++){
            // 判断注解参数的类型是否为 命令的参数
            if(parameterTypes[i].equals(String[].class)){

                // 参数集获取成功
                String[] str = (String[]) processor.getInputParameters().get(i);
                if (str.length < annotation.length()){
                    // 如果 注解填入的参数数量小于 当前 命令的参数数量则 抛出异常
                    throw new ParamsLengthException(annotation.value());
                }

            }

        }

        //找出String[]类型的参数
/*        System.out.println(parameterTypes.getClass().getName());*/

    }




    @Override
    public void regProcessor(Class proc) {
        this.stepInputAdapter.regHandler(proc);
    }


}
