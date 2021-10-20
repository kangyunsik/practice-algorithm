package com.codingtest.algorithm.programmers.q42626;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : scoville) {
            pq.offer(j);
        }

        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (poll >= K) {
                return answer;
            }
            if (pq.isEmpty())
                break;
            answer++;
            pq.offer(poll + pq.poll() * 2);
        }

        return -1;
    }
}