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
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class BukkitInputDispatch implements InputDispatch{

    @Inject
    StepInputAdapter stepInputAdapter = null;

    @Inject
    InputResultResolver inputResultResolver = null;


    @Override
    public boolean dispatchInputCommand(String name, CommandSender sender, Command cmd, String label, String[] params) throws AdapterParameterException, NotFoundProcessorException ,ParamsLengthException{

        InputProcessor processor = stepInputAdapter.findProcessor(name, sender, cmd, label, params);

        Model model = null;

        try{

            methodCheck(processor);

            model = processor.run();

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if(model==null){
            return false;
        }


        inputResultResolver.ResolverModel(model);


        return true;
    }


    private void methodCheck(InputProcessor processor)throws ParamsLengthException{

        Method joinPoint = processor.getJoinPointMethod();

        Check annotation = joinPoint.getAnnotation(Check.class);

        System.out.println("methodCheck(InputProcessor processor)");
        System.out.println(annotation);

        //没有使用Check检查
        if(annotation == null){
            return;
        }

        Class<?>[] parameterTypes = joinPoint.getParameterTypes();
        Parameter[] parameters = joinPoint.getParameters();

        for(int i=0;i<joinPoint.getParameterCount();i++){

            if(parameterTypes[i].equals(String[].class)){

                System.out.println(parameters[i].getName());

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
