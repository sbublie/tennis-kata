package com.cgi.tennis;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Score {

    private int p;

    public Score(int p) {
        this.p = p;
    }

    public void increment() {
        p++;
    }
}
