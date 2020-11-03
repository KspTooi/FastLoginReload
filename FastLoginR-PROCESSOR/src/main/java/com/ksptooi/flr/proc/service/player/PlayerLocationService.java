package com.ksptooi.flr.proc.service.player;

import com.ksptooi.flr.entity.player.PlayerLocation;

public interface PlayerLocationService {


    /**
     * 更新玩家位置信息
     * @param playerLocation
     */
    void updateLocation(PlayerLocation playerLocation);


}
