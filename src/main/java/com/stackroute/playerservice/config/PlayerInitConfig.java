package com.stackroute.playerservice.config;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class PlayerInitConfig implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerInitConfig(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    /**
     * setting values of initial players
     */

    @Value("${player.1.name:default}")
    String name1;
    @Value("${player.1.score:default}")
    int score1;

    @Value("${player.2.name:default}")
    String name2;
    @Value("${player.2.score:default}")
    int score2;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        playerRepository.save(new Player(1, name1, score1));
        playerRepository.save(new Player(2, name2, score2));
    }

    @Override
    public void run(String... args) throws Exception {

        playerRepository.save(new Player(1, "farhaan", 400));
    }
}
