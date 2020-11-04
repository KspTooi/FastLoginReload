package com.ksptooi.flr.proc.service.player;


import com.ksptooi.flr.proc.exception.StateUpdateException;
import org.bukkit.entity.Player;

/**
 * 玩家状态改变服务
 */
public interface PlayerStateService{


    /**
     * 玩家登入服务器时改变玩家数据库状态
     * @param player
     * @throws StateUpdateException 当数据库错误时抛出此异常
     */
    void playerJoinStateChange(Player player)throws StateUpdateException;

    /**
     * 玩家退出时改变玩家的数据库状态
     * @param player
     * @throws StateUpdateException 当数据库错误时抛出此异常
     */
    void playerQuitStateChange(Player player) throws StateUpdateException;

}