package com.cgi.tennis;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Score {

    private int p;

    public Score() {
        this.p = 0;
    }

    public void increment() {
        p++;
    }
}
