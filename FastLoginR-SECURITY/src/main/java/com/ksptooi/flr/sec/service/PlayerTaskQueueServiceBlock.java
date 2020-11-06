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
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class PlayerTaskQueueServiceBlock implements PlayerTaskQueueService {

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

        System.out.println("加入玩家进消息队列:"+player.getName());
        System.out.println("消息队列大小:"+Queue.getPlayerMessageQueue().size());
    }


    /**
     * 将玩家加入踢出队列
     *
     * @param player
     */
    @Override
    public void addToKickQueue(Player player) {

        Queue.getPlayerKickQueue().put(player, System.currentTimeMillis() + (1000 * 30L));

        System.out.println("加入玩家进踢出队列:"+player.getName());
        System.out.println("踢出队列大小:"+Queue.getPlayerKickQueue().size());

    }

    /**
     * 刷新玩家消息队列
     * -从消息队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshMessageQueue() {


        CopyOnWriteArraySet<Player> messageQueue = Queue.getPlayerMessageQueue();


        messageQueue.removeIf(player ->
                !player.isOnline()
                        ||mapper.getPlayerByAccount(
                                DtoUtil.toPlayer(player).getAccount()
                        ).isLogin()
        );


    }

    /**
     * 刷新玩家踢出队列
     * -从踢出队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshKickQueue() {

        HashMap<Player, Long> playerKickQueue = Queue.getPlayerKickQueue();

        //检查已登录或已退出的玩家
        Iterator<Map.Entry<Player,Long>> it = playerKickQueue.entrySet().iterator();

        while (it.hasNext()){

            Map.Entry<Player, Long> next = it.next();

            FLRPlayer playerByAccount = mapper.getPlayerByAccount(DtoUtil.toPlayer(next.getKey()).getAccount());

            Player key = next.getKey();

            if(playerByAccount.isLogin()){
                it.remove();
            }

            if(!key.isOnline()){
                it.remove();
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


        Iterator<Map.Entry<Player,Long>> it = playerKickQueue.entrySet().iterator();

        while (it.hasNext()){

            Map.Entry<Player, Long> next = it.next();

            if(next.getValue() < System.currentTimeMillis()){
                this.kick(next.getKey());
                it.remove();
            }

        }

    }


    public void kick(Player player) {

        Bukkit.getScheduler().runTask(SecurityModule.getPlugin(), new Runnable() {

            @Override
            public void run() {
                player.kickPlayer("登录超时!");
            }

        });

    }


}
