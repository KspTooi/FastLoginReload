package com.ksptooi.easydev.dispatch.adapter;

import com.ksptooi.easydev.entity.InputProcessor;
import com.ksptooi.easydev.exceptions.AdapterParameterException;
import com.ksptooi.easydev.exceptions.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface StepInputAdapter extends InputAdapter{




    InputProcessor findProcessor(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException, AdapterParameterException;


}
