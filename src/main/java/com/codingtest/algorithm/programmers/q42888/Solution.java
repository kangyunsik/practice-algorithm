package com.codingtest.algorithm.programmers.q42888;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> result = new LinkedList<>();

        for (String value : record) {
            String[] s = value.split(" ");
            if (s[0].equals("Enter")) {
                map.put(s[1], s[2]);
            } else if (s[0].equals("Change")) {
                map.put(s[1], s[2]);
            }
        }

        for (String value : record) {
            String[] s = value.split(" ");
            if (s[0].equals("Enter")) {
                result.add(map.get(s[1]) + "님이 들어왔습니다.");
            } else if (s[0].equals("Leave")) {
                result.add(map.get(s[1]) + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}