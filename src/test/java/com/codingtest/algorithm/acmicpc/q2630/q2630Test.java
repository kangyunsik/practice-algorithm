package com.codingtest.algorithm.acmicpc.q2630;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class q2630Test {

    @Test
    @DisplayName("예제 테스트")
    void pr_test(){
        Main main = new Main();
        int[] expectedAns = {9,7};
        int [][] array = new int[][]{
                {1,1,0,0,0,0,1,1},
                {1,1,0,0,0,0,1,1},
                {0,0,0,0,1,1,0,0},
                {0,0,0,0,1,1,0,0},
                {1,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,1,1,1,1,1,1},
                {0,0,1,1,1,1,1,1},
        };
        main.init(8,array);
        main.run();
        Assertions.assertThat(main.solution).isEqualTo(expectedAns);
    }
}