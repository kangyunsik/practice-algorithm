package com.codingtest.algorithm.programmers.q42576;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42576Test {
    @Test
    void pr_test1(){
        String[] parti = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        String expect = "leo";

        Solution solution = new Solution();
        String result = solution.solution(parti, comp);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String[] parti = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] comp = {"josipa", "filipa", "marina", "nikola"};
        String expect = "vinko";

        Solution solution = new Solution();
        String result = solution.solution(parti, comp);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        String[] parti = {"mislav", "stanko", "mislav", "ana"};
        String[] comp = {"stanko", "ana", "mislav"};
        String expect = "mislav";

        Solution solution = new Solution();
        String result = solution.solution(parti, comp);
        assertThat(result).isEqualTo(expect);
    }
}