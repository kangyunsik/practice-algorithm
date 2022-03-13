package com.codingtest.algorithm.programmers.q42890;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42890Test {

    @Test
    void pr_test(){
        String[][] inputs = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(inputs);
        assertThat(result).isEqualTo(exp);
    }

}