package com.cgi.tennis.score;

import com.cgi.tennis.Player;

public class AdvantageScore implements ScoreStrategy {
    private final Player pN;

    public AdvantageScore(Player pN) {
        this.pN = pN;
    }

    @Override
    public String getScore() {
        return "Advantage " + pN.getPN();
    }
}