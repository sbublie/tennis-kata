package com.cgi.tennis.manager;

public interface GameState {

    String getCurrentScore();
    void handlePointIncrement(String playerName);

}
