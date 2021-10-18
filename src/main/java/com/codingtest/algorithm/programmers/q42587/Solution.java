package com.codingtest.algorithm.programmers.q42587;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));
        int answer = 0;

        do {
            while (queue.stream().anyMatch(p -> p > queue.peek())){
                queue.offer(queue.poll());
                location = (location + queue.size() - 1) % queue.size();
            }
            queue.poll();
            location--;
            answer++;
        }while(!queue.isEmpty() && location >= 0);

        return answer;
    }
}
