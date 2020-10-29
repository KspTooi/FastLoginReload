package com.ksptooi.flr.mapper.player;

import com.google.inject.Singleton;
import com.ksptooi.flr.entity.player.FLRPlayer;

@Singleton
public class PlayerMapperBlock implements PlayerMapper {

    public FLRPlayer getPlayerById(Integer userId) {
        return null;
    }

    public FLRPlayer getPlayerByName(String userName) {
        return null;
    }

    public boolean checkPlayerName(String userName) {
        return false;
    }

    public boolean insertPlayer(FLRPlayer player) {
        return false;
    }

    public boolean removePlayer(String userId) {
        return false;
    }

    public boolean updatePlayer(FLRPlayer player) {
        return false;
    }

}
