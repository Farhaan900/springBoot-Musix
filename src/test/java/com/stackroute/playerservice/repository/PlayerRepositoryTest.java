package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PlayerRepositoryTest {

//    @Autowired
    private PlayerRepository playerRepository;

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("1","Shaikh",100);

    }

    @After
    public void tearDown() throws Exception {
//        playerRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
//        playerRepository.save(player);
//        Player fetchUser = playerRepository.findById(player.getId()).get();
//        Assert.assertEquals("1",fetchUser.getId());

    }

}