package com.cgi.tennis;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private final Score score;

    public Player(String name) {
        this.name = name;
        this.score = new Score();
    }

    public void won() {
        this.score.increment();
    }
}
