package com.codingtest.algorithm.q7662;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

//    @Test
//    void hashTest(){
//        Main main = new Main();
//        main.init(3);
//        Set<Long> set = main.set;
//        set.add(3L);
//        assertThat(set.size()).isEqualTo(1);
//        set.remove(3L);
//        assertThat(set.size()).isEqualTo(0);
//        set.remove(3L);
//        assertThat(set.size()).isEqualTo(0);
//
//        set.add(1L);
//        set.add(1L);
//
//        assertThat(set.contains(1L)).isEqualTo(true);
//    }

    @Test
    void pr_test(){
        Main main = new Main();
        main.init();
        for(String s : string1.split("\n"))
            main.run(s);

        System.out.println("main = " + main);
        assertThat(main.getAnswer()).isEqualTo("EMPTY");

        main = new Main();
        main.init();
        for(String s : string2.split("\n"))
            main.run(s);
        assertThat(main.getAnswer()).isEqualTo("333 -45");

        main = new Main();
        main.init();
        assertThat(main.getAnswer()).isEqualTo("EMPTY");
    }

    @Test
    void worst_case1(){
        Main main = new Main();
        main.init();

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
        main.init();

        for (int i = 0; i < 1000000; i++) {
            main.run("I "+ ((long)i*i) %1239711113);
        }

        assertThat(main.getAnswer()).isEqualTo("1239710321 0");
    }

    @Test
    void limit_case1(){
        Main main = new Main();
        main.init();
        main.run("I 1");
        main.run("I 3");
        main.run("I 2");

        main.run("D 1");
        main.run("D -1");

        for (Long minHeap : main.minHeap) {
            System.out.println("minHeap = " + minHeap);
        }

        for (Long maxHeap : main.maxHeap) {
            System.out.println("maxHeap = " + maxHeap);
        }


        assertThat(main.getAnswer()).isEqualTo("2 2");
    }

    @Test
    void board1(){
        Main main = new Main();
        main.init();
        main.run("I 100");
        main.run("I 100");
        main.run("D 1");

        assertThat(main.map.get(100L)).isEqualTo(1);
        assertThat(main.getAnswer()).isEqualTo("100 100");

    }

    @Test
    void delete_only(){
        Main main = new Main();
        main.init();
        for (int i = 0; i < 1000000; i++) {
            main.run("D 1");
        }
        assertThat(main.getAnswer()).isEqualTo("EMPTY");
    }

    @Test
    void getOneTest1(){
        Main main = new Main();
        main.init();
        main.run("I 2");
        main.run("I 3");
        main.run("D 1");

        assertThat(main.getAnswer()).isEqualTo("2 2");
    }

    @Test
    void getOneTest2(){
        Main main = new Main();
        main.init();
        main.run("I 2");

        assertThat(main.getAnswer()).isEqualTo("2 2");
    }

    @Test
    void getOneTest3(){
        Main main = new Main();
        main.init();
        main.run("I 4");
        main.run("I 3");
        main.run("I 4");
        main.run("D 1");
        main.run("D 1");

        assertThat(main.getAnswer()).isEqualTo("3 3");
    }

    @Test
    void board2(){
        String input = "I 5\n" +
                "I 3\n" +
                "I 7\n" +
                "I 6\n" +
                "D 1\n" +
                "D -1\n" +
                "D -1";
        String[] strings = input.split("\n");
        Main main = new Main();
        main.init();
        for(String s : strings)
            main.run(s);
        assertThat(main.getAnswer()).isEqualTo("6 6");
    }

    @Test
    void board3(){
        String input = "I 2\n" +
                "I 3\n" +
                "D -1\n" +
                "I 1\n" +
                "D 1";
        String[] strings = input.split("\n");
        Main main = new Main();
        main.init();
        for(String s : strings)
            main.run(s);
        assertThat(main.getAnswer()).isEqualTo("1 1");
    }

    @Test
    void null_q(){
        Main main = new Main();
        main.init();
        main.run("I 1");
        main.run("I 2");
        main.run("I 3");


        main.run("D 1");
        main.run("D 1");
        main.run("D -1");

        for (Long minHeap : main.minHeap) {
            System.out.println("minHeap = " + minHeap);
        }

        for (Long maxHeap : main.maxHeap) {
            System.out.println("maxHeap = " + maxHeap);
        }

        assertThat(main.getAnswer()).isEqualTo("EMPTY");
    }
}