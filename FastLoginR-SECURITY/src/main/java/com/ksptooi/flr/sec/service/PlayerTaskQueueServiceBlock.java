package com.ksptooi.flr.sec.service;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.sec.module.export.SecurityModule;
import com.ksptooi.flr.sec.queue.Queue;
import com.ksptooi.flr.util.DtoUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerTaskQueueServiceBlock implements PlayerTaskQueueService{

    @Inject
    PlayerMapper mapper = null;


    /**
     * 将玩家加入消息队列
     *
     * @param player
     */
    @Override
    public void addToMsgQueue(Player player) {
        Queue.getPlayerMessageQueue().add(player);
    }

    /**
     * 将玩家加入踢出队列
     *
     * @param player
     */
    @Override
    public void addToKickQueue(Player player) {
        Queue.getPlayerKickQueue().put(player,System.currentTimeMillis() + (1000 * 60L));
    }

    /**
     * 刷新玩家消息队列
     * -从消息队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshMessageQueue() {

        CopyOnWriteArrayList<Player> messageQueue = Queue.getPlayerMessageQueue();

        Player player = null;

        for(int i=0;i<messageQueue.size();i++){

            player = messageQueue.get(i);

            FLRPlayer playerByAccount = mapper.getPlayerByAccount(DtoUtil.toPlayer(player).getAccount());

            //已登录
            if(playerByAccount.isLogin()){
                messageQueue.remove(i);
            }

            //已退出
            if(!player.isOnline()){
                messageQueue.remove(i);
            }

        }

    }

    /**
     * 刷新玩家踢出队列
     * -从踢出队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshKickQueue() {

        HashMap<Player, Long> playerKickQueue = Queue.getPlayerKickQueue();

        //检查已退出或已登录的玩家
        for(Map.Entry<Player,Long>entry:playerKickQueue.entrySet()){

            FLRPlayer playerByAccount = mapper.getPlayerByAccount(DtoUtil.toPlayer(entry.getKey()).getAccount());

            //已登录
            if(playerByAccount.isLogin()){
                playerKickQueue.remove(entry.getKey());
            }

            //已经退出
            if(!entry.getKey().isOnline()){
                playerKickQueue.remove(entry.getKey());
            }

            // 玩家超时则踢出
            if (entry.getValue() < System.currentTimeMillis()){
                kickPlayer();
            }

        }

    }

    /**
     * 给队列中未登录的玩家发送消息
     *
     * @param msg
     */
    @Override
    public void sendMessage(String msg) {

        Queue.getPlayerMessageQueue().forEach(player -> {
            player.sendMessage(msg);
        });

    }

    /**
     * 踢出队列中超时的玩家
     */
    @Override
    public void kickPlayer() {

        HashMap<Player, Long> playerKickQueue = Queue.getPlayerKickQueue();

        //找出超时的玩家
        for(Map.Entry<Player,Long>entry:playerKickQueue.entrySet()){

            if(entry.getValue()<1){
                kick(entry.getKey());
                playerKickQueue.remove(entry.getKey());
            }

        }


    }




    public void kick(Player player){

        Bukkit.getScheduler().runTask(SecurityModule.getPlugin(), new Runnable() {

            @Override
            public void run() {
                player.kickPlayer("登录超时!");
            }

        });

    }



}
