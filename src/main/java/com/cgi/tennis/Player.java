package com.cgi.tennis;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

}
