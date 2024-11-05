package com.cgi.tennis;

import com.cgi.tennis.manager.GameStateManager;

import java.util.HashMap;
import java.util.Map;

// Single Responsibility Principle -> Most of the score management is moved to a dedicated class
public class TennisGameRefactored implements TennisGame {

    GameStateManager gameStateManager;

    public TennisGameRefactored(String playerName1, String playerName2) {
        Map<Integer, Player> players = new HashMap<>();
        players.put(1, new Player(playerName1));
        players.put(2, new Player(playerName2));
        Map<Integer, Score> scores = new HashMap<>();
        scores.put(1, new Score());
        scores.put(2, new Score());
        gameStateManager = new GameStateManager(players, scores);
    }

    public String getScore() {
        return gameStateManager.getCurrentScore();
    }

    public void wonPoint(String playerName) {
        gameStateManager.handlePointIncrement(playerName);
    }

}
