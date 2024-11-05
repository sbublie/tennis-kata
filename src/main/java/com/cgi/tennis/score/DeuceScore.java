package com.cgi.tennis.score;

public class DeuceScore implements ScoreStrategy {
    @Override
    public String getScore() {
        return "Deuce";
    }
}