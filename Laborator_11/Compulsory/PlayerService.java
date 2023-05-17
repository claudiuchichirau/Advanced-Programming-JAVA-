package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final List<Player> playerList = new ArrayList<>();

    public List<Player> getAllPlayers() {
        return playerList;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }
}
