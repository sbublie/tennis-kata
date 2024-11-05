package com.cgi.tennis;

import lombok.Getter;

@Getter
public class Player {
    private final String pN;

    public Player(String pN) {
        this.pN = pN;
    }

}
