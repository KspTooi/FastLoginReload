package com.ksptooi.flr.entity.model;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;

/**
 * 返回类型
 */
public class InputModel {

    private CommandSender sender = null;
    private ArrayList<String> message = new ArrayList<String>();
    private boolean finish = false;


    public InputModel(){

    }

    public InputModel(CommandSender sender){
        this.sender = sender;
    }


    public void addMessage(String msg){
        message.add(msg);
    }

    public CommandSender getSender() {
        return sender;
    }

    public void setSender(CommandSender sender) {
        this.sender = sender;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
