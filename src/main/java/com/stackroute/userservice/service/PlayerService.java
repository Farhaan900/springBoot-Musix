package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.userservice.exceptions.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {
    public Player saveMusix(Player player) throws PlayerAlreadyExistsException;
    public List<Player> getMusix();
    public Player getById (int id) throws PlayerNotFoundException;
    public void deleteById(int id);
    public boolean updateById(Player player, int id);
    public List<Player> getBYName(String name);
}
