package com.codingtest.algorithm.q5939;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class q5939Test {
    @Test
    void test() throws IOException {
        Main main = new Main();
        int[] value = {50,30,24,5,28,45,98,52,60};
        for (int j : value) {
            main.set(j);
        }
        main.run();
        main.bw.flush();
    }
}