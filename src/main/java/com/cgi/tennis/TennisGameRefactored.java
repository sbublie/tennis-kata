package com.cgi.tennis;

import com.cgi.tennis.score.*;

import java.util.Objects;

// Add score strategy pattern
public class TennisGameRefactored implements TennisGame {

    private int p2;
    private int p1;
    private final String p1N;
    private final String p2N;

    public TennisGameRefactored(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        return determineScoreStrategy().getScore();
    }

    private ScoreStrategy determineScoreStrategy() {

        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            return new RegularScore(p1, p2);
        }
        if (p1 == p2) {
            return new DeuceScore();
        }
        if ((p1-p2)*(p1-p2) == 1) {
            return new AdvantageScore(getLeadingPlayer());
        }
        return new WinScore(getLeadingPlayer());

    }

    private String getLeadingPlayer() {
        return p1 > p2 ? p1N : p2N;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.p1N))
            this.p1 += 1;
        else // Could also be removed but doesn't really hurt readability here
            this.p2 += 1;

    }
}
