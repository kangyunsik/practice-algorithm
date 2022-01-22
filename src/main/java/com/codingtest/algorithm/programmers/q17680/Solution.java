package com.codingtest.algorithm.programmers.q17680;

import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        ArrayDeque<String> cache = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.remove(city)) {
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                answer += 5;
            }
            cache.addLast(city);
        }
        return answer;
    }
}