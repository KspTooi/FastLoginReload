package com.ksptooi.flr.sec.task.daemon;


import com.google.inject.Inject;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;

/**
 * 玩家踢出队列
 */
public class PlayerKickTaskDaemon implements Runnable{

    @Inject
    PlayerTaskQueueService taskQueueService = null;

    @Override
    public void run() {

        System.out.println("[FastLoginR] DaemonThread - PlayerKickTask Started");

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



            //超出间隔则检查玩家是否超时
            taskQueueService.refreshKickQueue();
            taskQueueService.kickPlayer();


            second=0;
        }


    }



}
