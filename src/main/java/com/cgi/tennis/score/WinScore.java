package com.cgi.tennis.score;

public class WinScore implements ScoreStrategy {
    private final String pN;

    public WinScore(String pN) {
        this.pN = pN;
    }

    @Override
    public String getScore() {
        return "Win for " + pN;
    }
}