package com.cgi.tennis.score;

import com.cgi.tennis.Player;

public class AdvantageScore implements ScoreStrategy {
    private final Player player;

    public AdvantageScore(Player player) {
        this.player = player;
    }

    @Override
    public String getScore() {
        return "Advantage " + player.getName();
    }
}