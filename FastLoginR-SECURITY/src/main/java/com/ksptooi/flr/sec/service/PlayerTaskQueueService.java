package com.ksptooi.flr.sec.service;

/**
 * 玩家相关服务
 */
public interface PlayerTaskQueueService {

    /**
     * 刷新玩家消息队列
     *  -从消息队列中清除已登录或已经退出游戏的玩家
     */
    void refreshMessageQueue();

    /**
     * 刷新玩家踢出队列
     *  -从踢出队列中清除已登录或已经退出游戏的玩家
     */
    void refreshKickQueue();

    /**
     * 给队列中未登录的玩家发送消息
     * @param msg
     */
    void sendMessage(String msg);

    /**
     * 踢出队列中超时的玩家
     */
    void kickPlayer();

}
