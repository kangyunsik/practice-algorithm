package com.codingtest.algorithm.q10026;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class q10026Test {
    @Test
    void test(){
        int n = 5;
        String[] input = ("RRRBB\n" +
                "GGBBB\n" +
                "BBBRR\n" +
                "BBRRR\n" +
                "RRRRR").split("\n");
        Main main = new Main();
        main.init(n);
        for (int i = 0; i < n; i++) {
            main.set(i,input[i]);
        }

        Assertions.assertThat(main.getAnswer(false)).isEqualTo(4);
        Assertions.assertThat(main.getAnswer(true)).isEqualTo(3);
    }

}