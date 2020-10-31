package com.ksptooi.flr.mapper.player;


import com.ksptooi.flr.dao.exception.DBException;
import com.ksptooi.flr.entity.player.FLRPlayer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * 用户DAO
 */
public interface PlayerMapper {

    /**
     * 根据ID获取用户
     * @param userId
     * @return 用户实例
     */
    FLRPlayer getPlayerById(@Param("id") Integer userId)throws RuntimeException;

    /**
     * 根据名称获取用户
     * @param userName
     * @return 用户实例
     */
    FLRPlayer getPlayerByName(@Param("account") String userName)throws RuntimeException;

    /**
     * 加入新的用户
     * @param player
     * @return 受影响行数
     */
    Integer insertPlayer(FLRPlayer player)throws RuntimeException;

    /**
     * 移除用户
     * @param userId
     * @return 受影响行数
     */
    Integer removePlayer(@Param("id") String userId)throws RuntimeException;

    /**
     * 更新用户
     * @param player
     * @return 受影响行数
     */
    Integer updatePlayer(FLRPlayer player)throws RuntimeException;

}
