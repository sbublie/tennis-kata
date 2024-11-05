package com.cgi.tennis;

import java.util.Objects;

// Avoid multiple levels of indentation
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

        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            return getRegularResult();
        }
        if (p1 == p2) {
            return "Deuce";
        }
        if ((p1-p2)*(p1-p2) == 1) {
            return getAdvantage();
        }
        return getWin();

    }

    private String getWin() {
        return "Win for " + getLeadingPlayer();
    }

    private String getAdvantage(){
        return "Advantage " + getLeadingPlayer();
    }

    private String getLeadingPlayer() {
        return p1 > p2 ? p1N : p2N;
    }

    private String getRegularResult() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[p1];
        return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.p1N))
            this.p1 += 1;
        else // Could also be removed but doesn't really hurt readability here
            this.p2 += 1;

    }
}
