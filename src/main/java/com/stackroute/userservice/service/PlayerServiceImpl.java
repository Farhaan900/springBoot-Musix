package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.userservice.exceptions.PlayerNotFoundException;
import com.stackroute.userservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

//

    private PlayerRepository userRepository;

    @Autowired
    public PlayerRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(PlayerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PlayerServiceImpl(PlayerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Player saveMusix(Player player) throws PlayerAlreadyExistsException {

        if(userRepository.existsById(player.getId())){
            throw new PlayerAlreadyExistsException("Track already exists with id  : "+ player.getId());
        }

        Player savedPlayer = userRepository.save(player);

        return savedPlayer;
    }

    public List<Player> getMusix(){

        return (List<Player>)userRepository.findAll();

    }

    public Player getById(int id) throws PlayerNotFoundException {

        Optional<Player> user_id = userRepository.findById(id);


        if (!user_id.isPresent())
            throw new PlayerNotFoundException("Record not found");

        return user_id.get();

    }


    public void deleteById(int id) {
        userRepository.deleteById(id);

        }


    public boolean updateById(Player player, int id) {
        Optional<Player> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return false;
//            return ResponseEntity.notFound().build();

        player.setId(id);

        userRepository.save(player);
        return true;
    }


    public List<Player> getBYName(String name) {
        List<Player> user_id = userRepository.findByName(name);

        return user_id;
    }
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
        userRepository.save(new Player(1,name1,score1));
        userRepository.save(new Player(2,name2,score2));
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new Player(1,"farhaan",400));
    }
}
