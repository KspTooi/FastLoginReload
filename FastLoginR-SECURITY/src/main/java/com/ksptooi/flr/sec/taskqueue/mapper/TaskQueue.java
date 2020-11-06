package com.ksptooi.flr.sec.taskqueue.mapper;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 玩家操作队列
 */
public class TaskQueue {

    private static final CopyOnWriteArraySet<Player> playerMessageQueue = new CopyOnWriteArraySet<Player>();

    private static final HashMap<Player,Long> playerKickQueue = new HashMap<Player,Long>();


    public static HashMap<Player,Long> getPlayerKickQueue() {
        return playerKickQueue;
    }

    public static CopyOnWriteArraySet<Player> getPlayerMessageQueue() {
        return playerMessageQueue;
    }

    public synchronized static void removeFromMsgQueue(int index){
        playerMessageQueue.remove(index);
    }

}
