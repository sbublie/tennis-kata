package com.cgi.tennis.manager;

import com.cgi.tennis.Player;
import com.cgi.tennis.Score;
import com.cgi.tennis.score.*;

import java.util.Map;
import java.util.Objects;

public class GameStateManager implements GameState{

    private final Map<Integer, Player> players;

    public GameStateManager(Map<Integer, Player> players) {
        this.players = players;
    }

    @Override
    public String getCurrentScore() {
        return determineScoreStrategy().getScore();
    }

    @Override
    public void handlePointIncrement(String playerName) {
        Player playerToIncrement = findPlayerByName(playerName);

        if (playerToIncrement != null) {
            playerToIncrement.won();
        } else {
            System.out.println("Player not found: " + playerName);
        }
    }

    private Player findPlayerByName(String playerName) {
        for (Player player : players.values()) {
            if (Objects.equals(playerName, player.getName())) {
                return player;
            }
        }
        return null;
    }

    private ScoreStrategy determineScoreStrategy() {

        Score score1 = players.get(1).getScore();
        Score score2 = players.get(2).getScore();
        Player player1 = players.get(1);
        Player player2 = players.get(2);

        if (score1.isLessThan(4) && score2.isLessThan(4) && !(score1.sumIsEqualTo(score2, 6))) {
            return new RegularScore(score1, score2);
        }
        if (score1.isEqualTo(score2)) {
            return new DeuceScore();
        }
        if ((score1.subtract(score2) * (score1.subtract(score2)) == 1)) {
            return new AdvantageScore(getLeadingPlayer(player1, player2));
        }
        return new WinScore(getLeadingPlayer(player1, player2));
    }

    private Player getLeadingPlayer(Player player1, Player player2) {
        return player1.getScore().isHigher(player2.getScore()) ? player1 : player2;
    }

}
