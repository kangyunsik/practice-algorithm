package com.codingtest.algorithm.programmers.q42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.merge(name, 1, Integer::sum);
        }

        for (String name : completion) {
            Integer count = map.get(name);
            if(count.equals(1))
                map.remove(name);
            else
                map.put(name, count - 1);
        }

        return map.keySet().iterator().next();
    }
}
