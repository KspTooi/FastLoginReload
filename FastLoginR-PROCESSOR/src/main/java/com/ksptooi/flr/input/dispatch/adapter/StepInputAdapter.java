package com.ksptooi.flr.input.dispatch.adapter;

import com.ksptooi.flr.proc.exception.NotFoundProcessorException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface StepInputAdapter extends InputAdapter{


    void findProcessor(String name, CommandSender sender, Command cmd, String label, String[] params) throws NotFoundProcessorException;




}
