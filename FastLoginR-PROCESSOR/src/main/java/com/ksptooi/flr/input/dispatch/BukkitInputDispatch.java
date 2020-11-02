package com.ksptooi.flr.input.dispatch;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.input.dispatch.adapter.StepInputAdapter;
import com.ksptooi.flr.input.dispatch.resolver.InputResultResolver;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.lang.reflect.InvocationTargetException;

public class BukkitInputDispatch implements InputDispatch{

    @Inject
    StepInputAdapter stepInputAdapter = null;

    @Inject
    InputResultResolver inputResultResolver = null;


    @Override
    public boolean dispatchInputCommand(String name, CommandSender sender, Command cmd, String label, String[] params) throws AdapterParameterException, NotFoundProcessorException {

        InputProcessor processor = stepInputAdapter.findProcessor(name, sender, cmd, label, params);

        Model model = null;

        try{

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


    @Override
    public void regProcessor(Class proc) {
        this.stepInputAdapter.regHandler(proc);
    }


}
