package com.ksptooi.flr.input.listener;

import com.google.inject.Inject;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.entity.player.PlayerDetail;
import com.ksptooi.flr.entity.player.PlayerLocation;
import com.ksptooi.flr.proc.service.player.PlayerService;
import com.ksptooi.flr.proc.service.player.PlayerStateService;
import com.ksptooi.util.date.DateUtil;
import com.ksptooi.flr.entity.status.PlayerStatus;
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
    PlayerService service = null;

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

        Player pl = event.getPlayer();
        Location loc = pl.getLocation();

        FLRPlayer flrPlayer = service.getFLRPlayer(pl.getName());
        flrPlayer.setLeaveDate(DateUtil.getCurTimeString());
        flrPlayer.setLoginStatus(PlayerStatus.LOGIN_FAILED.getCode());

        PlayerLocation playerLocation = flrPlayer.getPlayerLocation();
        playerLocation.setX(loc.getX());
        playerLocation.setY(loc.getY());
        playerLocation.setZ(loc.getZ());
        playerLocation.setPitch((double) loc.getPitch());
        playerLocation.setY((double) loc.getYaw());

        PlayerDetail playerDetail = flrPlayer.getPlayerDetail();
        playerDetail.setExp((double) pl.getExp());
        playerDetail.setFoodLevel((double) pl.getFoodLevel());
        playerDetail.setHealthLevel(pl.getHealth());
        playerDetail.setLevel((double) pl.getLevel());

        //保存玩家位置
        //locationService.updateLocation(playerLocation);

        //保存玩家详细
        //detailService.updateDetail(playerDetail);

        //保存玩家



    }


}
