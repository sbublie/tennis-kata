package com.cgi.tennis;


// Avoid multiple levels of indentation
public class TennisGameRefactored implements TennisGame {

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGameRefactored(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {

        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            return getRegularResult();
        } else if (p1 == p2) {
            return "Deuce";
        } else {
            return getAdvantageOrWin();
        }
    }

    private String getAdvantageOrWin() {
        String s;
        s = p1 > p2 ? p1N : p2N;
        return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
    }

    private String getRegularResult() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[p1];
        return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
    }

    public void wonPoint(String playerName) {
        if (playerName == this.p1N)
            this.p1 += 1;
        else
            this.p2 += 1;

    }
}
