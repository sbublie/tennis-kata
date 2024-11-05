package com.cgi.tennis;

import lombok.Getter;

@Getter
public class Score {

    private int p = 0;

    public void increment() {
        this.p++;
    }

    public boolean isLessThan(int value) {
        return p < value;
    }

    public boolean isEqualTo(Score other) {
        return this.p == other.getP();
    }
    public boolean sumIsEqualTo(Score other, int value) {
        return (this.p + other.getP()) == value;
    }

    public int subtract(Score other) {
        return this.p - other.getP();
    }

    public boolean isHigher(Score other) {
        return this.p > other.getP();
    }
}
