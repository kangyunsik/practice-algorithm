package com.codingtest.algorithm.q1967;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q1967Test {

    @Test
    void pr_test(){
        int n = 12;
        int expected = 45;
        String[] inputs = ("1 2 3\n" +
                "1 3 2\n" +
                "2 4 5\n" +
                "3 5 11\n" +
                "3 6 9\n" +
                "4 7 1\n" +
                "4 8 7\n" +
                "5 9 15\n" +
                "5 10 4\n" +
                "6 11 6\n" +
                "6 12 10").split("\n");

        Main main = new Main(n);
        for (String input : inputs) {
            main.set(input);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}