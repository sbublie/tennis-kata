package com.cgi.tennis;

import lombok.Getter;

@Getter
public class Score {

    private int points = 0;

    public void increment() {
        this.points++;
    }

    public boolean isLessThan(int value) {
        return points < value;
    }

    public boolean isEqualTo(Score other) {
        return this.points == other.getPoints();
    }
    public boolean sumIsEqualTo(Score other, int value) {
        return (this.points + other.getPoints()) == value;
    }

    public int subtract(Score other) {
        return this.points - other.getPoints();
    }

    public boolean isHigher(Score other) {
        return this.points > other.getPoints();
    }
}
