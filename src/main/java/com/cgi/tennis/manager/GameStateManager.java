package com.cgi.tennis.manager;

import com.cgi.tennis.Player;
import com.cgi.tennis.Score;
import com.cgi.tennis.score.*;

import java.util.Map;
import java.util.Objects;

public class GameStateManager implements GameState{

    private final Map<Integer, Player> players;
    private final Map<Integer, Score> scores;

    public GameStateManager(Map<Integer, Player> players, Map<Integer, Score> scores) {

        this.players = players;
        this.scores = scores;
    }

    @Override
    public String getCurrentScore() {
        return determineScoreStrategy().getScore();
    }

    @Override
    public void handlePointIncrement(String playerName) {

        if (Objects.equals(playerName, this.players.get(1).getName()))
            this.scores.get(1).increment();
        else
            this.scores.get(2).increment();
    }

    private ScoreStrategy determineScoreStrategy() {

        Score score1 = scores.get(1);
        Score score2 = scores.get(2);
        Player player1 = players.get(1);
        Player player2 = players.get(2);

        if (score1.isLessThan(4) && score2.isLessThan(4) && !(score1.sumIsEqualTo(score2, 6))) {
            return new RegularScore(score1, score2);
        }
        if (score1.isEqualTo(score2)) {
            return new DeuceScore();
        }
        if ((score1.subtract(score2) * (score1.subtract(score2)) == 1)) {
            return new AdvantageScore(getLeadingPlayer(score1, score2));
        }
        return new WinScore(getLeadingPlayer(score1, score2));
    }

    private Player getLeadingPlayer(Score score1, Score score2) {
        return score1.isHigher(score2) ? players.get(1) : players.get(2);
    }

}
