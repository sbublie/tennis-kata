package com.cgi.tennis.score;

public class AdvantageScore implements ScoreStrategy {
    private final String pN;

    public AdvantageScore(String pN) {
        this.pN = pN;
    }

    @Override
    public String getScore() {
        return "Advantage " + pN;
    }
}