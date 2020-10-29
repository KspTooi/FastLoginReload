package com.ksptooi.flr.mapper.player;

import com.ksptooi.flr.entity.player.PlayerDetail;
import org.apache.ibatis.annotations.Param;

public interface PlayerDetailMapper {


    /**
     * 根据玩家pid获取到信息存档
     * @param pid
     * @return 玩家信息存档
     */
    PlayerDetail getDetailByPID(@Param("pid") String pid);

    /**
     * 加入玩家信息存档
     * @param playerDetail
     * @return 受影响行数
     */
    Integer insertDetail(PlayerDetail playerDetail);

    /**
     * 移除玩家信息存档
     * @param id
     * @return 受影响行数
     */
    Integer removeDetail(@Param("id") String id);

    /**
     * 修改玩家信息存档
     * @param playerDetail
     * @return 受影响行数
     */
    Integer updateDetail(PlayerDetail playerDetail);


}
