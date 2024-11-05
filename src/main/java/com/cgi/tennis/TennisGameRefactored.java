package com.cgi.tennis;

import com.cgi.tennis.score.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Abbreviations removed / variable naming improved
public class TennisGameRefactored implements TennisGame {

    private final Map<Integer, Player> players = new HashMap<>();
    private final Map<Integer, Score> scores = new HashMap<>();

    public TennisGameRefactored(String playerName1, String playerName2) {
        players.put(1, new Player(playerName1));
        players.put(2, new Player(playerName2));
        scores.put(1, new Score());
        scores.put(2, new Score());
    }

    public String getScore() {
        return determineScoreStrategy().getScore();
    }

    private ScoreStrategy determineScoreStrategy() {

        Score score1 = scores.get(1);
        Score score2 = scores.get(2);

        if (score1.isLessThan(4) && score2.isLessThan(4) && !(score1.sumIsEqualTo(score2, 6))) {
            return new RegularScore(score1, score2);
        }
        if (score1.isEqualTo(score2)) {
            return new DeuceScore();
        }
        if ((score1.subtract(score2) * (score1.subtract(score2)) == 1)) {
            return new AdvantageScore(getLeadingPlayer());
        }
        return new WinScore(getLeadingPlayer());

    }

    private Player getLeadingPlayer() {
        return scores.get(1).isHigher(scores.get(2)) ? players.get(1) : players.get(2);
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.players.get(1).getName()))
            this.scores.get(1).increment();
        else // Could also be removed but doesn't really hurt readability here
            this.scores.get(2).increment();

    }
}
