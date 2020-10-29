package com.ksptooi.flr.mapper.player;


import com.ksptooi.flr.entity.player.FLRPlayer;
import org.apache.ibatis.annotations.Param;

/**
 * 用户DAO
 */
public interface PlayerMapper {

    /**
     * 根据ID获取用户
     * @param userId
     * @return 用户实例
     */
    FLRPlayer getPlayerById(@Param("id") Integer userId);

    /**
     * 根据名称获取用户
     * @param userName
     * @return 用户实例
     */
    FLRPlayer getPlayerByName(String userName);

    /**
     * 检查用户名字是否已经存在
     * @return 已存在返回true 不存在返回false
     */
    boolean checkPlayerName(String userName);

    /**
     * 加入新的用户
     * @param player
     * @return 成功返回true 失败返回false
     */
    boolean insertPlayer(FLRPlayer player);

    /**
     * 移除用户
     * @param userId
     * @return 成功返回true 失败返回false
     */
    boolean removePlayer(String userId);


    /**
     * 更新用户
     * @param player
     * @return 成功返回true 失败返回false
     */
    boolean updatePlayer(FLRPlayer player);

}
