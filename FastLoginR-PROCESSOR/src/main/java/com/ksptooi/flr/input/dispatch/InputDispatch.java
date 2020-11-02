package com.ksptooi.flr.input.dispatch;

import com.ksptooi.flr.entity.input.proc.InputProcessor;
import com.ksptooi.flr.entity.model.Model;
import com.ksptooi.flr.proc.exception.AdapterParameterException;
import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface InputDispatch {

    boolean dispatchInputCommand(String name, CommandSender sender, Command cmd, String label, String[] params) throws AdapterParameterException, NotFoundProcessorException;

    void regProcessor(Class proc);

}

