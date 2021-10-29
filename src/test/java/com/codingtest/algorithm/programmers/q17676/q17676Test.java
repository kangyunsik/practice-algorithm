package com.codingtest.algorithm.programmers.q17676;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class q17676Test {
    @Test
    void test(){
        String[] strings = {"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(strings);
        Assertions.assertThat(result).isEqualTo(exp);
    }

    @Test
    void test2(){
        String[] strings = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(strings);
        Assertions.assertThat(result).isEqualTo(exp);
    }

    @Test
    void test3(){
        String[] strings = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        int exp = 7;
        Solution solution = new Solution();
        int result = solution.solution(strings);
        Assertions.assertThat(result).isEqualTo(exp);
    }
}