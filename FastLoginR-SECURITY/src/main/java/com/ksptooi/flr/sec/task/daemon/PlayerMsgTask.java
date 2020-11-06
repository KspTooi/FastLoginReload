package com.ksptooi.flr.sec.task.daemon;


import com.google.inject.Inject;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;

/**
 * 玩家消息队列
 */
public class PlayerMsgTask implements Runnable{

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

            //如果未超出间隔则继续循环
            if(second<interval){
                continue;
            }

            taskQueueService.refreshMessageQueue();
            taskQueueService.sendMessage("§e[FastLogin]§b你需要登录后才能操作,使用/login 密码 来登录");

            //超出间隔则向玩家发送信息
            second=0;
        }

    }




}