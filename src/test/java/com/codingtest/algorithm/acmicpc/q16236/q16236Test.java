//package com.codingtest.algorithm.acmicpc.q16236;
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class q16236Test {
//    @Test
//    void test1(){
//        int n = 3;
//        String[] strings = ("0 0 0\n" +
//                "0 0 0\n" +
//                "0 9 0").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(0);
//    }
//
//    @Test
//    void test2(){
//        int n = 3;
//        String[] strings = ("0 0 1\n" +
//                "0 0 0\n" +
//                "0 9 0").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(3);
//    }
//
//    @Test
//    void test3(){
//        int n = 4;
//        String[] strings = ("4 3 2 1\n" +
//                "0 0 0 0\n" +
//                "0 0 9 0\n" +
//                "1 2 3 4").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(14);
//    }
//
//    @Test
//    void test4(){
//        int n = 6;
//        String[] strings = ("5 4 3 2 3 4\n" +
//                "4 3 2 3 4 5\n" +
//                "3 2 9 5 6 6\n" +
//                "2 1 2 3 4 5\n" +
//                "3 2 1 6 5 4\n" +
//                "6 6 6 6 6 6").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(60);
//    }
//
//    @Test
//    void test5(){
//        int n = 6;
//        String[] strings = ("6 0 6 0 6 1\n" +
//                "0 0 0 0 0 2\n" +
//                "2 3 4 5 6 6\n" +
//                "0 0 0 0 0 2\n" +
//                "0 2 0 0 0 0\n" +
//                "3 9 3 0 0 1").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(48);
//    }
//
//    @Test
//    void test6(){
//        int n = 6;
//        String[] strings = ("1 1 1 1 1 1\n" +
//                "2 2 6 2 2 3\n" +
//                "2 2 5 2 2 3\n" +
//                "2 2 2 4 6 3\n" +
//                "0 0 0 0 0 6\n" +
//                "0 0 0 0 0 9").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(39);
//    }
//
//    @Test
//    void test7(){
//        int n = 20;
//        String[] strings = ("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 9 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
//                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1").split("\n");
//        Main main = new Main(n);
//        for (int i = 0; i < n; i++) {
//            main.set(i,strings[i]);
//        }
//        main.run();
//        assertThat(main.getAnswer()).isEqualTo(399);
//    }
//}