package com.ksptooi.flr.sec.taskqueue.mapper;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 玩家操作队列
 */
public class TaskQueue {


    private static final CopyOnWriteArrayList<Player> playerMessageQueue = new CopyOnWriteArrayList<Player>();

    private static final ConcurrentHashMap<Player,Long> playerKickQueue = new ConcurrentHashMap<Player,Long>();


    public static CopyOnWriteArrayList<Player> getMQ(){
        return playerMessageQueue;
    }

    public static ConcurrentHashMap<Player,Long> getKQ(){
        return playerKickQueue;
    }


    public static ConcurrentHashMap<Player,Long> getPlayerKickQueue() {
        return playerKickQueue;
    }

    public static CopyOnWriteArrayList<Player> getPlayerMessageQueue() {
        return playerMessageQueue;
    }

    public synchronized static void removeFromMsgQueue(int index){
        playerMessageQueue.remove(index);
    }

}
