package com.cgi.tennis.score;

import com.cgi.tennis.Player;

public class WinScore implements ScoreStrategy {
    private final Player player;

    public WinScore(Player player) {
        this.player = player;
    }

    @Override
    public String getScore() {
        return "Win for " + player.getName();
    }
}