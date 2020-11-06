package com.ksptooi.flr.sec.service;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.sec.module.export.SecurityModule;
import com.ksptooi.flr.sec.taskqueue.mapper.TaskQueue;
import com.ksptooi.flr.util.DtoUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class PlayerTaskQueueServiceBlock implements PlayerTaskQueueService {

    @Inject
    PlayerMapper mapper = null;


    CopyOnWriteArrayList<Player> mq = TaskQueue.getMQ();

    ConcurrentHashMap<Player, Long> kq = TaskQueue.getKQ();

    /**
     * 将玩家加入消息队列
     *
     * @param player
     */
    @Override
    public void addToMsgQueue(Player player) {

        mq.removeIf(pl->pl.getName().equalsIgnoreCase(player.getName()));
        mq.add(player);

        System.out.println("加入玩家进消息队列:"+player.getName());
        System.out.println("消息队列大小:"+ mq.size());
    }


    /**
     * 将玩家加入踢出队列
     *
     * @param player
     */
    @Override
    public void addToKickQueue(Player player) {

        for(Map.Entry<Player, Long> en:kq.entrySet()){

            if(en.getKey().getName().equalsIgnoreCase(player.getName())){
                kq.remove(en.getKey());
            }

        }

        kq.put(player, System.currentTimeMillis() + (1000 * 30L));


        System.out.println("加入玩家进踢出队列:"+player.getName());
        System.out.println("踢出队列大小:"+ kq.size());

    }

    /**
     * 刷新玩家消息队列
     * -从消息队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshMessageQueue() {


        mq.removeIf(player ->
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


        for(Map.Entry<Player, Long> en:kq.entrySet()){

            String account = DtoUtil.toPlayer(en.getKey()).getAccount();

            if(!en.getKey().isOnline()){
                kq.remove(en.getKey());
            }
            if(mapper.getPlayerByAccount(account).isLogin()){
                kq.remove(en.getKey());
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

        mq.forEach(player -> {
            player.sendMessage(msg);
        });

    }

    /**
     * 踢出队列中超时的玩家
     */
    @Override
    public void kickPlayer() {


        for(Map.Entry<Player, Long> en:kq.entrySet()){

            if(en.getValue() < System.currentTimeMillis()){
                this.kick(en.getKey());
                kq.remove(en.getKey());
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
