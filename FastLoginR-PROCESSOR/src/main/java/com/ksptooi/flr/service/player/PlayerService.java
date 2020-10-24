package com.ksptooi.flr.service.player;


import com.ksptooi.flr.entity.player.FLRPlayer;


/**
 * 用户服务类
 */
public interface PlayerService {


    /**
     * 玩家登录
     * @param playerName
     * @param pwd
     * @return 成功返回玩家实例 失败返回null
     */
    FLRPlayer playerLogin(String playerName,String pwd);

    /**
     * 玩家登出
     * @param playerName
     * @return 成功返回true 失败返回false
     */
    boolean playerLogout(String playerName);


}
