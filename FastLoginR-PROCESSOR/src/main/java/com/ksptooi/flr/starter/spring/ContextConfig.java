package com.ksptooi.flr.starter.spring;


import com.ksptooi.flr.dal.player.PlayerDAO;
import com.ksptooi.flr.dal.player.PlayerdaoBlock;
import com.ksptooi.flr.service.player.PlayerService;
import com.ksptooi.flr.service.player.PlayerServiceBlock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.ksptooi.flr.dal", "com.ksptooi.flr.service"})
public class ContextConfig {


    @Bean
    public PlayerService playerService(){
        return new PlayerServiceBlock();
    }

}
