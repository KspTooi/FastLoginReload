package com.ksptooi.flr.sec.queue;


import org.bukkit.entity.Player;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 玩家消息队列
 */
public class PlayerMsgTask implements Runnable{

    private static CopyOnWriteArrayList<Player> playerList = new CopyOnWriteArrayList<Player>();

    @Override
    public void run() {

        int second = 0;
        int interval = 8;

        while(true){

            second++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //如果未超出间隔则继续循环
            if(second<interval){
                continue;
            }



            playerList.forEach(pl -> {
                pl.sendMessage("§e[FastLogin]§b你需要登录后才能操作,使用/login 密码 来登录");
            });

            //超出间隔则向玩家发送信息
            second=0;

        }

    }

    public static synchronized void addPlayer(Player player){
        playerList.add(player);
    }

    public static synchronized void removePlayer(String playerName){

        for(int i=0;i<playerList.size();i++){

            if(playerList.get(i).getName().equalsIgnoreCase(playerName)){
                playerList.remove(i);
            }

        }

    }


}