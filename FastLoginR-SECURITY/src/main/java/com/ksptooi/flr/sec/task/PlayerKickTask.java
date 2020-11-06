package com.ksptooi.flr.sec.task;


import com.google.inject.Inject;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;
import org.bukkit.entity.Player;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 玩家踢出队列
 */
public class PlayerKickTask implements Runnable{

    @Inject
    PlayerTaskQueueService taskQueueService = null;

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

            System.out.println(second);

            //如果未超出间隔则继续循环
            if(second<interval){
                continue;
            }



            //超出间隔则检查玩家是否超时
            taskQueueService.refreshKickQueue();
            taskQueueService.kickPlayer();


            second=0;
        }


    }



}
