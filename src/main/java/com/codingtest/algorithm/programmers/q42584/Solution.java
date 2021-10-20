package com.codingtest.algorithm.programmers.q42584;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> indexes = new Stack<>();

        int cur = 0;
        for (int i = 0; i < prices.length; i++) {
            cur++;
            while (!indexes.isEmpty() && prices[indexes.peek()] > prices[i]) {
                Integer pop = indexes.pop();
                answer[pop] = cur - pop - 1;
            }
            indexes.push(i);
        }
        while (!indexes.isEmpty()) {
            Integer pop = indexes.pop();
            answer[pop] = cur - pop - 1;
        }

        return answer;
    }
}
