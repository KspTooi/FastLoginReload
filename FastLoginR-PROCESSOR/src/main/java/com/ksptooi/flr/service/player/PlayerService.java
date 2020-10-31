package com.ksptooi.flr.service.player;


import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.proc.exception.AuthException;
import org.bukkit.entity.Player;


/**
 * 用户服务类
 */
public interface PlayerService {


    /**
     * 玩家注册
     * @param player
     * @return 注册
     */
    FLRPlayer playerRegister(FLRPlayer player) throws AuthException;

    /**
     * 玩家登录
     * @param playerName
     * @param pwd
     * @return 成功返回玩家实例 失败返回null
     */
    FLRPlayer playerLogin(String playerName,String pwd) throws AuthException;

    /**
     * 玩家登出
     * @param playerName
     * @return 成功返回true 失败返回false
     */
    boolean playerLogout(String playerName);

    /**
     * 根据玩家名称获取玩家数据对象
     * @param playerName
     * @return 玩家数据对象
     */
    FLRPlayer getFLRPlayer(String playerName);
}
