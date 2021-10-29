package com.codingtest.algorithm.programmers.q43162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!check[i]){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();
                    check[poll] = true;
                    for (int j = 0; j < computers[poll].length; j++) {
                        if(!check[j] && computers[poll][j] == 1){
                            queue.offer(j);
                        }
                    }
                }
                answer ++;
            }
        }

        return answer;
    }
}