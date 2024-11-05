package com.cgi.tennis.score;

public class RegularScore implements ScoreStrategy {
    private final int score1;
    private final int score2;

    public RegularScore(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    @Override
    public String getScore() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[score1];
        return (score1 == score2) ? s + "-All" : s + "-" + p[score2];
    }
}