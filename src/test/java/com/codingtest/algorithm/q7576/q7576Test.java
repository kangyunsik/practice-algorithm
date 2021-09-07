package com.codingtest.algorithm.q7576;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class q7576Test {

    String[][] getStrings(int[][] array) {
        String[][] strings = new String[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                strings[i][j] = String.valueOf(array[i][j]);
            }
        }
        return strings;
    }

    @Test
    void pr_test1() {
        String[][] array = new String[][]{
                {"0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "1"}
        };

        Main main = new Main();
        main.init(6, 4, array);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(8);
    }

    @Test
    void pr_test2() {
        int[][] array = new int[][]{
                {0, -1, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1}
        };

        Main main = new Main();
        main.init(6, 4, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(-1);
    }

    @Test
    void pr_test3() {
        int[][] array = new int[][]{
                {1, -1, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, -1, 1}
        };

        Main main = new Main();
        main.init(6, 4, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(6);
    }

    @Test
    void pr_test4() {
        int[][] array = new int[][]{
                {-1, 1, 0, 0, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, -1, -1, -1, 0},
                {0, 0, 0, 0, 0}
        };

        Main main = new Main();
        main.init(5, 5, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(14);
    }

    @Test
    void pr_test5() {
        int[][] array = new int[][]{
                {1, -1},
                {-1, 1}
        };

        Main main = new Main();
        main.init(2, 2, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(0);
    }

    @Test
    void pr_test6() {
        int[][] array = new int[][]{
                {1, 0},
                {0, 0}
        };

        Main main = new Main();
        main.init(2, 2, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(2);
    }

    @Test
    void pr_test7() {
        int[][] array = new int[][]{
                {0, 0},
                {0, 0}
        };

        Main main = new Main();
        main.init(2, 2, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(-1);
    }

    @Test
    void pr_test8() {
        int[][] array = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        Main main = new Main();
        main.init(4, 4, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(0);
    }

    @Test
    void pr_test9_worstcase() {
        int[][] array = new int[1000][1000];

        array[0][0] = 1;

        for (int i = 0; i < 1000; i++) {
            if (i % 4 == 1) {
                for (int j = 0; j < 999; j++) {
                    array[i][j] = -1;
                }
            }

            if (i % 4 == 3) {
                for (int j = 1; j < 1000; j++) {
                    array[i][j] = -1;
                }
            }
        }

        Main main = new Main();
        main.init(1000, 1000, getStrings(array));
        main.run();
        assertThat(main.getAnswer()).isEqualTo(500499);
    }
}