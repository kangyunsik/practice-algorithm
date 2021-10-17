package com.codingtest.algorithm.programmers.q42586;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> answer = new Stack<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1));
        }

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            if (max < poll){
                max = poll;
                answer.push(1);
            }else{
                answer.push(answer.pop()+1);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}