package com.codingtest.algorithm.q11659;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q11659Test {

    @Test
    void test(){
        int[] array = {5,4,3,2,1};
        int[] answer = {12,9,1};
        Main main = new Main();
        main.init(array);
        main.run();
        assertThat(main.getAnswer(1,3)).isEqualTo(answer[0]);
        assertThat(main.getAnswer(2,4)).isEqualTo(answer[1]);
        assertThat(main.getAnswer(5,5)).isEqualTo(answer[2]);
    }


    @Test
    void test2(){
        int[] array = {5};
        int[] answer = {5};
        Main main = new Main();
        main.init(array);
        main.run();
        assertThat(main.getAnswer(1,1)).isEqualTo(answer[0]);
    }
}