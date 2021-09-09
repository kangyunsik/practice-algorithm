package com.codingtest.algorithm.q1541;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1541Test {

    private void printArray(int[][] array){
        for (int[] pr : array){
            for (int p : pr)
                System.out.print(p+"\t\t");
            System.out.println();
        }
    }

    @Test
    void test(){
        Main main = new Main();
        main.init("3+4-5+103");
        main.run();
        printArray(main.dynamic);
        assertThat(main.getAnswer()).isEqualTo(-101);
    }

    @Test
    void pr_test(){
        Main main = new Main();
        main.init("55-50+40");
        main.run();
        printArray(main.dynamic);
        assertThat(main.getAnswer()).isEqualTo(-35);
    }

    @Test
    void limit_test1(){
        Main main = new Main();
        main.init("35");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(35);
    }

    @Test
    void limit_test2(){
        Main main = new Main();
        main.init("3+4");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(7);
    }

    @Test
    void limit_test3(){
        Main main = new Main();
        main.init("22222+33333+11111");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(66666);
    }

    @Test
    void limit_test4(){
        Main main = new Main();
        main.init("4-44444");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(-44440);
    }

    @Test
    void board_test(){
        Main main = new Main();
        main.init("0-101-01");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(-102);
    }

    @Test
    void board_test2(){
        Main main = new Main();
        main.init("50+50-100+100-100-100");
        main.run();
        printArray(main.dynamic);
        assertThat(main.getAnswer()).isEqualTo(-300);
    }

    @Test
    void limit_test5(){
        Main main = new Main();
        main.init("0");
        main.run();
        assertThat(main.getAnswer()).isEqualTo(0);
    }
}