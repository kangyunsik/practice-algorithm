package com.codingtest.algorithm.q7662;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class q7662Test {
    String string1 = "I 16\n" +
            "I -5643\n" +
            "D -1\n" +
            "D 1\n" +
            "D 1\n" +
            "I 123\n" +
            "D -1";

    String string2 = "I -45\n" +
            "I 653\n" +
            "D 1\n" +
            "I -642\n" +
            "I 45\n" +
            "I 97\n" +
            "D 1\n" +
            "D -1\n" +
            "I 333";

    @Test
    void pr_test(){
        Main main = new Main();
        main.init(7);
        for(String s : string1.split("\n"))
            main.run(s);
        assertThat(main.getAnswer()).isEqualTo("EMPTY");

        main = new Main();
        main.init(9);
        for(String s : string2.split("\n"))
            main.run(s);
        assertThat(main.getAnswer()).isEqualTo("333 -45");

        main = new Main();
        main.init(0);
        assertThat(main.getAnswer()).isEqualTo("EMPTY");
    }

    @Test
    void worst_case1(){
        Main main = new Main();
        main.init(1000000);

        for (int i = 0; i < 1000000; i++) {
            if(i%3 != 2)
                main.run("I "+i);
            else
                main.run("D 1");
        }

        assertThat(main.getAnswer()).isEqualTo("999999 0");
    }

    @Test
    void worst_case2(){
        Main main = new Main();
        main.init(1000000);

        for (int i = 0; i < 1000000; i++) {
            main.run("I "+ ((long)i*i) %1239711113);
            if(i%1000 == 0)
                System.out.println("i = " + i);
        }

        System.out.println(main.getAnswer());
        //assertThat(main.getAnswer()).isEqualTo("999999 0");
    }
}