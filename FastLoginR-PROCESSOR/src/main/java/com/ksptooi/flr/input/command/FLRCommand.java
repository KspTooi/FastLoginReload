package com.ksptooi.flr.input.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface FLRCommand {

    String name = null;

    void exec(CommandSender sender, Command cmd, String[] args);

}
