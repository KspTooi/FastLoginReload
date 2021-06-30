package com.ksptooi.easydev.entity;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;

/**
 * 返回类型
 */
public class Model {

    private CommandSender sender = null;
    private ArrayList<String> message = new ArrayList<String>();
    private boolean finish = false;


    public Model(){

    }

    public Model(CommandSender sender){
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

    public void finish(){
        this.finish = true;
    }
}
