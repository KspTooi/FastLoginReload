package com.ksptooi.flr.sec.input.listener;

import com.ksptooi.flr.sec.queue.Queue;
import com.ksptooi.flr.sec.service.PlayerTaskQueueService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 *
 */
public class PlayerJoinListener implements Listener {

    PlayerTaskQueueService service = null;

    public PlayerJoinListener(PlayerTaskQueueService service){
        this.service = service;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void asyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event){

        String PlayerName=event.getName().toLowerCase();

        for(Player pl: Bukkit.getServer().getOnlinePlayers()){

            if(pl.getName().toLowerCase().equalsIgnoreCase(PlayerName)){
                event.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
                event.setKickMessage("登录失败:相同用户名的玩家已经在游戏中!");
            }

        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerLoginEvent(PlayerLoginEvent event){

        //Queue.getPlayerMessageQueue().add(event.getPlayer());
        service.addToMsgQueue(event.getPlayer());
        service.addToKickQueue(event.getPlayer());

    }



}
