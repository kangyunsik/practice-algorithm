package com.codingtest.algorithm.programmers.q92334;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> info = new HashMap<>();
        Map<String, Integer> mapper = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            mapper.put(id_list[i], i);
        }

        for (String r : report) {
            String[] split = r.split(" ");
            Set<String> reporters = info.getOrDefault(split[1], new HashSet<>());
            reporters.add(split[0]);
            info.put(split[1], reporters);
        }

        for (String target : info.keySet()) {
            if(info.get(target).size() >= k){
                for (String reporter : info.get(target)) {
                    answer[mapper.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
