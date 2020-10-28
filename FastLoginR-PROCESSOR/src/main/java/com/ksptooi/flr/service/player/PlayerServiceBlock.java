package com.ksptooi.flr.service.player;

import com.google.inject.Singleton;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.entity.player.FLRPlayer;
import org.bukkit.entity.Player;

@Singleton
public class PlayerServiceBlock implements PlayerService{

    PlayerMapper playerDAO = null;

    public FLRPlayer playerRegister(Player player) {

        System.out.println("DAO类"+playerDAO);
        return null;
    }

    public FLRPlayer playerLogin(String playerName, String pwd) {
        return null;
    }

    public boolean playerLogout(String playerName) {
        return false;
    }
}
