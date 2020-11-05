package com.ksptooi.flr.sec.queue;


import org.bukkit.entity.Player;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 玩家踢出队列
 */
public class PlayerKickTask implements Runnable{

    private CopyOnWriteArrayList<Player> playerList = new CopyOnWriteArrayList<Player>();

    @Override
    public void run() {

        int second = 0;
        int interval = 8;



    }



}
