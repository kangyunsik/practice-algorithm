package com.codingtest.algorithm.programmers.q42890;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int n, answer;
    String[][] relation;
    List<Integer> possList = new ArrayList<>();

    public int solution(String[][] relation) {
        n = relation[0].length;
        this.relation = relation;
        findCases(0, 0);
        for (int candidate : possList) {
            answer++;
            for (int temp : possList) {
                if((candidate & temp) == temp && temp != candidate) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    private void findCases(int depth, int flag) {
        if (depth == n) {
            if (isUniqueness(flag)) possList.add(flag);
            return;
        }
        findCases(depth + 1, flag | (1 << depth));
        findCases(depth + 1, flag);
    }

    private boolean isUniqueness(int flag) {
        Set<String> all = new HashSet<>();
        StringBuilder sb;
        for (String[] strings : relation) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((flag & 1 << j) > 0) {
                    sb.append(strings[j]).append(".");
                }
            }
            all.add(sb.toString());
        }
        return all.size() == relation.length;
    }
}