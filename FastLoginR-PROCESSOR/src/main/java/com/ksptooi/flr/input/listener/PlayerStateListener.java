package com.ksptooi.flr.input.listener;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.entity.player.PlayerDetail;
import com.ksptooi.flr.entity.player.PlayerLocation;
import com.ksptooi.flr.proc.exception.StateUpdateException;
import com.ksptooi.flr.proc.service.player.PlayerService;
import com.ksptooi.flr.proc.service.player.PlayerStateService;
import com.ksptooi.flr.util.DateUtil;
import com.ksptooi.flr.entity.status.PlayerStatus;
import com.ksptooi.flr.util.DtoUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 玩家状态变化监听器
 */
public class PlayerStateListener implements Listener {

    @Inject
    PlayerStateService stateService = null;


    @EventHandler
    public void playerLoginEvent(PlayerLoginEvent event){
    }

    /**
     * 玩家退出
     * @param event
     */
    @EventHandler
    public void playerQuitEvent (PlayerQuitEvent event){

        try{

            stateService.playerQuitStateChange(event.getPlayer());

        } catch (StateUpdateException e) {
            e.printStackTrace();
        }

    }


}
