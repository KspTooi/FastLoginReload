package com.ksptooi.flr.sec.service;

import com.google.inject.Inject;
import com.ksptooi.flr.mapper.player.PlayerMapper;

public class PlayerTaskQueueServiceBlock implements PlayerTaskQueueService{

    @Inject
    PlayerMapper mapper = null;


    /**
     * 刷新玩家消息队列
     * -从消息队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshMessageQueue() {

    }

    /**
     * 刷新玩家踢出队列
     * -从踢出队列中清除已登录或已经退出游戏的玩家
     */
    @Override
    public void refreshKickQueue() {

    }

    /**
     * 给队列中未登录的玩家发送消息
     *
     * @param msg
     */
    @Override
    public void sendMessage(String msg) {

    }

    /**
     * 踢出队列中超时的玩家
     */
    @Override
    public void kickPlayer() {

    }
}
