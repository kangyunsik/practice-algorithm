package com.codingtest.algorithm.programmers.q1835;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> permuted = new ArrayList<>();

    public int solution(int n, String[] data) {
        int answer = 0;
        initPermuted(new StringBuilder("ACFJMNRT"), 0);
        lb: for (String s : permuted) {
            for (String opt : data) {
                if (!valid(s, opt.toCharArray()))
                    continue lb;
            }
            answer++;
        }
        return answer;
    }

    private boolean valid(String s, char[] opt) {
        int dist = Integer.parseInt(opt[4] + "") + 1;
        int abs = Math.abs(s.indexOf(opt[0]) - s.indexOf(opt[2]));
        return (opt[3] == '=' && abs == dist) ||
                (opt[3] == '<' && abs < dist) ||
                (opt[3] == '>' && abs > dist);
    }

    private void initPermuted(StringBuilder sb, int depth) {
        if (depth == 8) {
            permuted.add(sb.toString());
            return;
        }
        for (int i = depth; i < 8; i++) {
            swap(sb, depth, i);
            initPermuted(sb, depth + 1);
            swap(sb, depth, i);
        }
    }

    private void swap(StringBuilder sb, int depth, int i) {
        char temp = sb.charAt(depth);
        sb.setCharAt(depth, sb.charAt(i));
        sb.setCharAt(i, temp);
    }
}