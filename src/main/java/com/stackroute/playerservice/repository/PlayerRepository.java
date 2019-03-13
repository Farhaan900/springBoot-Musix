package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Player repository to query player information
 */

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query(value = "SELECT p FROM Player p where p.name =?1")
    List<Player> findByName(String name);
}
