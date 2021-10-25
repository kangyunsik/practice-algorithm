package com.codingtest.algorithm.programmers.q42860;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String name) {
        if (name.matches("[A]*"))
            return 0;

        int answer = 0;
        int len = name.length();
        int[] ints = new int[len];
        Set<Integer> check = new HashSet<>();

        for (int i = 0; i < len; i++) {
            Integer value = getValue(name.charAt(i));
            ints[i] = value;
            if (value == 0) {
                check.add(i);
            }
        }

        int locate = 0;
        int move = 0;
        while (check.size() != len) {
            check.add(locate);
            answer += ints[locate] + Math.abs(move);

            int left_move = 1;
            while (left_move < len && (ints[(len + locate - left_move) % len] == 0 || check.contains((len + locate - left_move) % len))) {
                left_move++;
            }
            int right_move = 1;
            while (right_move < len && (ints[(locate + right_move) % len] == 0 || check.contains((locate + right_move) % len))) {
                right_move++;
            }

            if(left_move >= len || right_move >= len)
                break;

            move = left_move >= right_move ? right_move : -left_move;

            locate += move + len;
            locate %= len;
        }

        return answer;
    }

    private Integer getValue(char c) {
        return Math.min(26 - (c - 'A'), c - 'A');
    }
}