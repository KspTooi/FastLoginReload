package com.ksptooi.flr.input.dispatch;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.annotation.Check;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.input.dispatch.resolver.InputResultResolver;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import com.ksptooi.flr.proc.exception.ParamsLengthException;
import com.ksptooi.flr.proc.exception.ServiceException;
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

        Check annotation = joinPoint.getAnnotation(Check.class);

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
