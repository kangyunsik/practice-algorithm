package com.codingtest.algorithm.programmers.q42862;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Set<Integer> set = new HashSet<>();
        Set<Integer> lost_set = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int j : lost) {
            lost_set.add(j);
        }

        for (int j : reserve) {
            if (lost_set.contains(j)) {
                lost_set.remove(j);
                set.remove(j);
                answer++;
            } else
                set.add(j);
        }

        for (int value : lost) {
            if (lost_set.contains(value)) {
                if (set.contains(value)) {
                    set.remove(value);
                    answer++;
                } else if (set.contains(value - 1)) {
                    set.remove(value - 1);
                    answer++;
                } else if (set.contains(value + 1)) {
                    set.remove(value + 1);
                    answer++;
                }
            }
        }
        return answer;
    }
}