package com.ksptooi.flr.proc.service.player;


import org.bukkit.entity.Player;

/**
 * 玩家状态改变服务
 */
public interface PlayerStateService{

    /**
     * 玩家退出时改变玩家的数据库状态
     * @param player
     */
    void playerQuitStateChange(Player player);

}