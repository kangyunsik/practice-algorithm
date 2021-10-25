package com.codingtest.algorithm.programmers.q17684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("",0);
        for (int i = 0; i < 26; i++) {
            map.put((char)('A' + i) + "", i+1);
        }

        int i = 0;
        int k = 0;
        while(i < msg.length() && k < msg.length()) {
            k = i;
            while(k <= msg.length() && map.containsKey(msg.substring(i,k))){
                k++;
            }
            if(k <= msg.length()) {
                map.put(msg.substring(i, k), map.size());
                answer.add(map.get(msg.substring(i, k - 1)));
                i = k -1;
            }
        }

        answer.add(map.get(msg.substring(i) + ""));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}