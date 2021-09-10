package com.codingtest.algorithm.datastructure;

import org.junit.jupiter.api.Test;

class EratosthenesTest {
    @Test
    void test(){
        Eratosthenes eratosthenes = new Eratosthenes(100000);
        eratosthenes.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(eratosthenes.list.get(i));
        }
    }
}