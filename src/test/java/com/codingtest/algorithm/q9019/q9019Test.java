package com.codingtest.algorithm.q9019;

import com.codingtest.algorithm.q9019.Main;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q9019Test {
    @Test
    void simpleTest() {
        Integer[] next = {1, 3, 2};
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(next));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        String[] strings = new String[3];
        strings[1] = "";
        System.out.println(strings[1].length());
    }

    @Test
    void pr_test() {
        String input = "1234 3412";
        String expected = "LL"; // 여러 값이 가능할 수 있음. (RR 가능)

        Main main = new Main();
        main.set(input);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void pr_test2() {
        String input = "1000 1";
        String expected = "L";  // 여러 값이 가능할 수 있음.

        Main main = new Main();
        main.set(input);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void pr_test3() {
        String input = "1 16";
        String expected = "DDDD";   // 여러 값이 가능할 수 있음.

        Main main = new Main();
        main.set(input);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}