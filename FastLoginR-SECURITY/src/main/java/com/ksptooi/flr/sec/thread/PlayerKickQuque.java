package com.ksptooi.flr.sec.thread;


import org.bukkit.entity.Player;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 玩家踢出队列
 */
public class PlayerKickQuque implements Runnable{

    private CopyOnWriteArrayList<Player> playerList = new CopyOnWriteArrayList<Player>();

    @Override
    public void run() {

        int second = 0;
        int interval = 8;



    }



}
