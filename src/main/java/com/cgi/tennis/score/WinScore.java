package com.cgi.tennis.score;

import com.cgi.tennis.Player;

public class WinScore implements ScoreStrategy {
    private final Player pN;

    public WinScore(Player pN) {
        this.pN = pN;
    }

    @Override
    public String getScore() {
        return "Win for " + pN.getPN();
    }
}