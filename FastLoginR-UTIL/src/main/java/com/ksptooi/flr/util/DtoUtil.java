package com.ksptooi.flr.util;


import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.entity.player.PlayerDetail;
import com.ksptooi.flr.entity.player.PlayerLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * 数据访问对象通用工具
 */
public class DtoUtil {


    /**
     * 将Bukkit玩家对象转换为Flr玩家对象
     * @param player
     * @return
     */
    public static FLRPlayer toPlayer(Player player){
        return toPlayer(null,player);
    }

    /**
     * 将Bukkit玩家对象转换为Flr玩家对象
     * @param player
     * @return
     */
    public static FLRPlayer toPlayer(FLRPlayer fPlayer,Player player){

        FLRPlayer flrPlayer = new FLRPlayer();
        PlayerLocation loc = new PlayerLocation();
        PlayerDetail detail = new PlayerDetail();

        if(fPlayer != null){
            flrPlayer = fPlayer;
            loc = fPlayer.getPlayerLocation();
            detail = fPlayer.getPlayerDetail();
        }

        Location ploc = player.getLocation();

        flrPlayer.setAccount(player.getName().toLowerCase());
        flrPlayer.setPlayerName(player.getName());

        //置入玩家位置
        loc.setX(ploc.getX());
        loc.setY(ploc.getY());
        loc.setZ(ploc.getZ());
        loc.setPitch(ploc.getPitch());
        loc.setYaw(ploc.getYaw());
        loc.setWorld(ploc.getWorld().getName());

        //置入玩家详细
        detail.setLevel(player.getLevel());
        detail.setHealthLevel(player.getHealth());
        detail.setFoodLevel(player.getFoodLevel());
        detail.setExp(player.getExp());

        //赋值给FlrPlayer
        flrPlayer.setPlayerLocation(loc);
        flrPlayer.setPlayerDetail(detail);

        return flrPlayer;
    }

}
