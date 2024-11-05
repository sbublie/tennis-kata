package com.cgi.tennis;

import com.cgi.tennis.score.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Created class collections/HashMaps
public class TennisGameRefactored implements TennisGame {

    private final Map<Integer, Player> players = new HashMap<Integer, Player>();
    private final Map<Integer, Score> scores = new HashMap<>();

    public TennisGameRefactored(String p1N, String p2N) {
        players.put(1, new Player(p1N));
        players.put(2, new Player(p2N));
        scores.put(1, new Score());
        scores.put(2, new Score());
    }

    public String getScore() {
        return determineScoreStrategy().getScore();
    }

    private ScoreStrategy determineScoreStrategy() {

        if (scores.get(1).getP() < 4 && scores.get(2).getP() < 4 && !(scores.get(1).getP() + scores.get(2).getP() == 6)) {
            return new RegularScore(scores.get(1), scores.get(2));
        }
        if (scores.get(1).getP() == scores.get(2).getP()) {
            return new DeuceScore();
        }
        if ((scores.get(1).getP()-scores.get(2).getP())*(scores.get(1).getP()-scores.get(2).getP()) == 1) {
            return new AdvantageScore(getLeadingPlayer());
        }
        return new WinScore(getLeadingPlayer());

    }

    private Player getLeadingPlayer() {
        return scores.get(1).getP() > scores.get(2).getP() ? players.get(1) : players.get(2);
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.players.get(1).getPN()))
            this.scores.get(1).increment();
        else // Could also be removed but doesn't really hurt readability here
            this.scores.get(2).increment();

    }
}
