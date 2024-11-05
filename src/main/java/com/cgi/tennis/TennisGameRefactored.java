package com.cgi.tennis;

import com.cgi.tennis.manager.GameStateManager;

import java.util.HashMap;
import java.util.Map;

// Cohesion Improvement -> Score is now directly related to Player
public class TennisGameRefactored implements TennisGame {

    GameStateManager gameStateManager;

    public TennisGameRefactored(String playerName1, String playerName2) {
        Map<Integer, Player> players = new HashMap<>();
        players.put(1, new Player(playerName1));
        players.put(2, new Player(playerName2));
        gameStateManager = new GameStateManager(players);
    }

    public String getScore() {
        return gameStateManager.getCurrentScore();
    }

    public void wonPoint(String playerName) {
        gameStateManager.handlePointIncrement(playerName);
    }

}
