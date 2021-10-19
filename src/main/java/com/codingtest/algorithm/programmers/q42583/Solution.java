package com.codingtest.algorithm.programmers.q42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int l, int w, int[] tw) {
        int remain = w;
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            queue.offer(0);
        }
        int c = 0;

        while (c < tw.length) {
            ans++;
            remain += queue.poll();

            if (remain >= tw[c]) {
                remain -= tw[c];
                queue.offer(tw[c++]);
            } else {
                queue.offer(0);
            }

        }

        return ans + queue.size();
    }
}
