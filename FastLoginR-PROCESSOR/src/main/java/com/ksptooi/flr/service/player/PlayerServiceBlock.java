package com.ksptooi.flr.service.player;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ksptooi.flr.entity.player.PlayerDetail;
import com.ksptooi.flr.entity.player.PlayerLocation;
import com.ksptooi.flr.mapper.player.PlayerDetailMapper;
import com.ksptooi.flr.mapper.player.PlayerLocationMapper;
import com.ksptooi.flr.mapper.player.PlayerMapper;
import com.ksptooi.flr.entity.player.FLRPlayer;
import com.ksptooi.util.dictionary.PlayerStatus;
import org.bukkit.Bukkit;
import org.mybatis.guice.transactional.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
@Transactional
public class PlayerServiceBlock implements PlayerService{


    @Inject
    PlayerMapper mapper = null;

    @Inject
    PlayerLocationMapper locMapper = null;

    @Inject
    PlayerDetailMapper detailMapper = null;


    /**
     * 玩家注册
     * @param player
     * @return 注册
     */
    @Override
    public FLRPlayer playerRegister(FLRPlayer player) {

        FLRPlayer playerByName = mapper.getPlayerByName(player.getAccount());

        if(playerByName != null){
            throw new RuntimeException("用户名已存在");
        }

        String presentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

        //注册业务流程
        player.setLastLoginDate(presentDate);
        player.setRegisterDate(presentDate);
        player.setRegisterStatus(PlayerStatus.REG_SUCCESS.getCode());
        player.setLoginStatus(PlayerStatus.LOGIN_SUCCESS.getCode());
        player.setLoginCount(1);

        //添加用户进表
        Integer insertPlayer = mapper.insertPlayer(player);

        //添加用户位置进表(使用主键回填值)
        PlayerLocation loc = new PlayerLocation();
        loc.setPid(player.getPid());

        Integer insertPlayerLoc = locMapper.insertLocation(loc);

        //添加用户详细进表
        PlayerDetail playerDetail = new PlayerDetail();
        playerDetail.setPid(player.getPid());
        Integer insertDetail = detailMapper.insertDetail(playerDetail);

        //判断添加是否成功 如果不成功则回滚事务

        if(insertPlayer<1 || insertPlayerLoc<1 || insertDetail<1){
            throw new RuntimeException("添加玩家数据失败!");
        }

        //添加成功则返回玩家实例
        return player;
    }

    /**
     * 玩家登录
     * @param playerName
     * @param pwd
     * @return 成功返回玩家实例 失败返回null
     */
    @Override
    public FLRPlayer playerLogin(String playerName, String pwd) {

        FLRPlayer playerByName = mapper.getPlayerByName(playerName);

        //玩家不存在
        if(playerByName == null){
            return null;
        }

        //登录逻辑


        if(!playerByName.getPassword().equals(pwd)){
            return null;
        }

        //修改数据库中玩家的状态
        playerByName.setLastLoginDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        playerByName.setLoginCount(playerByName.getLoginCount()+1);

        //修改数据库中的登录状态
        playerByName.setLoginStatus(PlayerStatus.LOGIN_SUCCESS.getCode());


        return playerByName;
    }

    /**
     * 玩家登出
     * @param playerName
     * @return 成功返回true 失败返回false
     */
    @Override
    public boolean playerLogout(String playerName) {

        FLRPlayer playerByName = mapper.getPlayerByName(playerName);

        playerByName.setLeaveDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        playerByName.setLoginStatus(PlayerStatus.LOGIN_FAILED.getCode());

        return true;
    }

    /**
     * 根据玩家名称获取玩家数据对象
     * @param playerName
     * @return 玩家数据对象
     */
    @Override
    public FLRPlayer getFLRPlayer(String playerName) {
        return mapper.getPlayerByName(playerName);
    }

}
