package com.ksptooi.flr.service.player;

import com.ksptooi.flr.dal.player.PlayerDAO;
import com.ksptooi.flr.entity.player.FLRPlayer;
import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceBlock implements PlayerService{

    PlayerDAO playerDAO = null;

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
