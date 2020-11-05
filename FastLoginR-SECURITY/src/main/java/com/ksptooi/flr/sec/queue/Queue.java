package com.ksptooi.flr.sec.queue;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 玩家操作队列
 */
public class Queue {

    private static final CopyOnWriteArrayList<Player> playerMessageQueue = new CopyOnWriteArrayList<Player>();

    private static final HashMap<Player,Integer> playerKickQueue = new HashMap<Player,Integer>();


    public static HashMap<Player,Integer> getPlayerKickQueue() {
        return playerKickQueue;
    }

    public static CopyOnWriteArrayList<Player> getPlayerMessageQueue() {
        return playerMessageQueue;
    }

    public synchronized static void removeFromMsgQueue(int index){
        playerMessageQueue.remove(index);
    }

}
