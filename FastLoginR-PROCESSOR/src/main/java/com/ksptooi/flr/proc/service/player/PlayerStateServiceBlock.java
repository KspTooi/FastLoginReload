package com.ksptooi.flr.proc.service.player;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.flr.entity.status.ErrorStatus;
import com.ksptooi.flr.entity.status.AuthState;
import com.ksptooi.flr.mapper.player.PlayerDetailMapper;
import com.ksptooi.flr.mapper.player.PlayerLocationMapper;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.proc.exception.StateUpdateException;
import com.ksptooi.flr.util.DateUtil;
import com.ksptooi.flr.util.DtoUtil;
import org.bukkit.entity.Player;
import org.mybatis.guice.transactional.Transactional;

import java.util.UUID;

@Singleton
@Transactional
public class PlayerStateServiceBlock implements PlayerStateService {

    @Inject
    PlayerMapper mapper = null;

    @Inject
    PlayerLocationMapper locMapper = null;

    @Inject
    PlayerDetailMapper detMapper = null;

    /**
     * 玩家登入服务器时改变玩家数据库状态
     *
     * @param player
     * @throws StateUpdateException 当数据库错误时抛出此异常
     */
    @Override
    public void playerJoinStateChange(Player player) throws StateUpdateException {

    }

    /**
     * 玩家退出时改变玩家的数据库状态
     *
     * @param player
     */
    @Override
    public void playerQuitStateChange(Player player) throws StateUpdateException {


        //获取玩家最新状态
        FLRPlayer flrPlayer = DtoUtil.toPlayer(mapper.getPlayerByAccount(player.getName()), player);

        //更新玩家状态
        flrPlayer.setAuthStatus(AuthState.LOGIN_UNDONE.getCode());
        //flrPlayer.setLoginStatus(PlayerStatus.LOGIN_FAILED.getCode());
        flrPlayer.setLeaveDate(DateUtil.getCurTimeString());

        //更新数据库
        Integer updatePlayer = mapper.updatePlayer(flrPlayer);
        Integer updateLocation = locMapper.updateLocation(flrPlayer.getPlayerLocation());
        Integer updateDetail = detMapper.updateDetail(flrPlayer.getPlayerDetail());

        //检查更新状态
        if(updatePlayer<1 || updateLocation<1 || updateDetail<1){
            throw new StateUpdateException(ErrorStatus.FATAL_DB);
        }

    }



}
