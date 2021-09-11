package com.codingtest.algorithm.kakao.q1;

import com.codingtest.algorithm.kakao.q1.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    @Test
    void test(){
        String[] s = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] i = {"muzi", "frodo", "apeach", "neo"};
        int[] result = {2,1,1,0};
        Solution solution = new Solution();
        assertThat(solution.solution(i,s,2)).isEqualTo(result);
    }


    @Test
    void test2(){
        String[] s = {"ryan con", "ryan con", "ryan con", "ryan con"};
        String[] i = {"con","ryan"};
        int[] result = {0,0};
        Solution solution = new Solution();
        assertThat(solution.solution(i,s,3)).isEqualTo(result);
    }
}