package com.ksptooi.easydev.dispatch;


import com.ksptooi.easydev.exceptions.AdapterParameterException;
import com.ksptooi.easydev.exceptions.NotFoundProcessorException;
import com.ksptooi.easydev.exceptions.ParamsLengthException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface InputDispatch {

    boolean dispatchInputCommand(String name, CommandSender sender, Command cmd, String label, String[] params) throws AdapterParameterException, NotFoundProcessorException, ParamsLengthException;

    void regProcessor(Class proc);

}

