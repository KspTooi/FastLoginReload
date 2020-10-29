package com.ksptooi.flr.mapper.player;


import com.ksptooi.flr.entity.player.PlayerLocation;
import org.apache.ibatis.annotations.Param;

/**
 * 用户位置DAO
 */
public interface PlayerLocationMapper {


    /**
     * 根据用户pid获取用户的位置存档
     * @param playerId
     * @return
     */
    PlayerLocation getLocationByPID(@Param("pid") Integer playerId);

    /**
     * 加入用户位置
     * @param location 用户位置
     * @return 受影响行数
     */
    Integer insertLocation(PlayerLocation location);

    /**
     * 移除用户位置
     * @param locationId 用户位置ID
     * @return 受影响行数
     */
    Integer removeLocation(@Param("id")String locationId);

    /**
     * 更新用户位置
     * @param location 位置实例
     * @return 受影响行数
     */
    Integer updateLocation(PlayerLocation location);

}
