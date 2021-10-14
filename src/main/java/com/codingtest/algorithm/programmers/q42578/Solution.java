package com.codingtest.algorithm.programmers.q42578;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes)
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);

        for (String key : map.keySet())
            answer *= map.get(key)+1;

        return answer - 1;
    }
}
