package com.ksptooi.flr.dal.player;

import com.ksptooi.flr.entity.player.FLRPlayer;
import org.springframework.stereotype.Component;



@Component
public class PlayerdaoBlock implements PlayerDAO{

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
