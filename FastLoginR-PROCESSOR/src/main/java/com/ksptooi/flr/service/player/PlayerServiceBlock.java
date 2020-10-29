package com.ksptooi.flr.service.player;

import com.google.inject.Singleton;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.entity.player.FLRPlayer;
import org.bukkit.entity.Player;

@Singleton
public class PlayerServiceBlock implements PlayerService{


    /**
     * 玩家注册
     *
     * @param player
     * @return 注册
     */
    @Override
    public FLRPlayer playerRegister(Player player) {
        return null;
    }

    /**
     * 玩家登录
     *
     * @param playerName
     * @param pwd
     * @return 成功返回玩家实例 失败返回null
     */
    @Override
    public FLRPlayer playerLogin(String playerName, String pwd) {
        return null;
    }

    /**
     * 玩家登出
     *
     * @param playerName
     * @return 成功返回true 失败返回false
     */
    @Override
    public boolean playerLogout(String playerName) {
        return false;
    }

    /**
     * 根据玩家名称获取玩家数据对象
     *
     * @param playerName
     * @return 玩家数据对象
     */
    @Override
    public FLRPlayer getFLRPlayer(String playerName) {
        return null;
    }
}
