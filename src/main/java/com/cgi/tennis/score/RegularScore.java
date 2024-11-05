package com.cgi.tennis.score;

import com.cgi.tennis.Score;

public class RegularScore implements ScoreStrategy {
    private final Score score1;
    private final Score score2;

    public RegularScore(Score score1, Score score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    @Override
    public String getScore() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[score1.getPoints()];
        return (score1.getPoints() == score2.getPoints()) ? s + "-All" : s + "-" + p[score2.getPoints()];
    }
}