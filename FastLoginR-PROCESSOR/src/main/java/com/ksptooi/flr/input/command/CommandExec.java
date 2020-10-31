package com.ksptooi.flr.input.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandExec {
    void exec(CommandSender sender, Command cmd, String[] args);
}
