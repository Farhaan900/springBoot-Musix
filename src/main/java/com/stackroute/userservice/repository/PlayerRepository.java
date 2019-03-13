package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends CrudRepository <Player, Integer> {

    @Query(
            value = "SELECT * FROM MUSIX ",
            nativeQuery = true)
    Collection<Player> findAllActiveUsers();

    @Query(
            value = "SELECT * FROM MUSIX ",
            nativeQuery = true)
    List<Player> findByName(String name);
}
