package com.codingtest.algorithm.codility.lessons.lesson1.binarygap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class taskTest {
    @Test
    void pr_test1(){
        Solution solution = new Solution();
        int result = solution.solution(1041);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void pr_test2(){
        Solution solution = new Solution();
        int result = solution.solution(32);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void pr_test3(){
        Solution solution = new Solution();
        int result = solution.solution((int)Math.pow(2,32)-1);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void pr_test4(){
        Solution solution = new Solution();
        int result = solution.solution(1);
        Assertions.assertThat(result).isEqualTo(0);
    }
}