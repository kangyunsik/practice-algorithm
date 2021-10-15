package com.codingtest.algorithm.acmicpc.q11286;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class q11286Test {

    @Test
    void test(){
        int n = 18;
        int[] array = {1,-1,0,0,0,1,1,-1,-1,2,-2,0,0,0,0,0,0,0};
        int[] expected = {-1,1,0,-1,-1,1,1,-2,2,0};
        ArrayList<Integer> expected_answer = new ArrayList<>();
        for (int integer : expected) {
            expected_answer.add(integer);
        }

        Main main = new Main();
        main.init(n);
        for (int i : array) {
            main.run(i);
        }
        assertThat(main.getAnswer()).isEqualTo(expected_answer);
    }
}