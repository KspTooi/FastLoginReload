package com.ksptooi.flr.input.api;


import com.ksptooi.flr.entity.player.FLRPlayer;
import org.bukkit.entity.Player;

/**
 * Api接口 附属插件联动
 */
public interface FastLoginRApi {

    /**
     * API - 玩家登录
     * @param player
     */
    void forceLogin(Player player)throws Exception;

    /**
     * API - 玩家注销
     * @param player
     * @throws Exception
     */
    void forceLogout(Player player)throws Exception;

    /**
     * API - 玩家注册
     * @param player
     * @throws Exception
     */
    void registerPlayer(FLRPlayer player)throws Exception;

}
