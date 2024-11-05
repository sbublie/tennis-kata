package com.cgi.tennis;

import com.cgi.tennis.score.*;

import java.util.Objects;

// Wrap primitive types
public class TennisGameRefactored implements TennisGame {

    private final Score p1;
    private final Score p2;
    private final Player p1N;
    private final Player p2N;

    public TennisGameRefactored(String p1N, String p2N) {

        this.p1 = new Score(0);
        this.p2 = new Score(0);
        this.p1N = new Player(p1N);
        this.p2N = new Player(p2N);
    }

    public String getScore() {
        return determineScoreStrategy().getScore();
    }

    private ScoreStrategy determineScoreStrategy() {

        if (p1.getP() < 4 && p2.getP() < 4 && !(p1.getP() + p2.getP() == 6)) {
            return new RegularScore(p1, p2);
        }
        if (p1.getP() == p2.getP()) {
            return new DeuceScore();
        }
        if ((p1.getP()-p2.getP())*(p1.getP()-p2.getP()) == 1) {
            return new AdvantageScore(getLeadingPlayer());
        }
        return new WinScore(getLeadingPlayer());

    }

    private Player getLeadingPlayer() {
        return p1.getP() > p2.getP() ? p1N : p2N;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.p1N.getPN()))
            this.p1.increment();
        else // Could also be removed but doesn't really hurt readability here
            this.p2.increment();

    }
}
