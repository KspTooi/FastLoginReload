package com.ksptooi.flr.input.listener;

import com.google.inject.Inject;
import com.ksptooi.flr.proc.exception.StateUpdateException;
import com.ksptooi.flr.proc.service.player.PlayerStateService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 玩家状态变化监听器
 */
public class PlayerStateListener implements Listener {


    PlayerStateService stateService = null;

    @Inject
    public PlayerStateListener(PlayerStateService stateService){
        this.stateService = stateService;
    }

    public PlayerStateListener(){

    }

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
