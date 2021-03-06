package com.stackroute.playerservice.service;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {
    public Player savePlayer(Player player) throws PlayerAlreadyExistsException;

    public List<Player> getPlayers();

    public Player getById(int id) throws PlayerNotFoundException;

    public void deleteById(int id) throws PlayerNotFoundException;

    public void updateById(Player player, int id) throws PlayerNotFoundException;

    public List<Player> getBYName(String name);
}
