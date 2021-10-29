package com.codingtest.algorithm.programmers.q60062;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class q60062Test {
    @Test
    void tree_test() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(1);
        set.add(3);
        System.out.println("set.subSet(10,true,10,true) = " + set.subSet(10,true,10,true));
    }

    @Test
    void pr_test(){
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int n = 12;
        int[] weak = {1,3,4,9,10};
        int[] dist = {3,5,7};
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int n = 12;
        int[] weak = {1,3};
        int[] dist = {1};
        int exp = -1;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        int n = 200;
        int[] weak = {0,100};
        int[] dist = {1,1};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test5(){
        int n = 200;
        int[] weak = {0,10,50,80,120,160};
        int[] dist = {1,10,5,40,30};
        int exp = 3;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test6(){
        int n = 200;
        int[] weak = {0,10};
        int[] dist = {10};
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(n, weak, dist);
        assertThat(result).isEqualTo(exp);
    }
}