package com.codingtest.algorithm.programmers.q92341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    int[] fees;
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> answer = new TreeMap<>();  // 차량 번호, 총 시간
        Map<String, Integer> time = new HashMap<>();  // 차량 번호, 입차 시간
        this.fees = fees;

        Arrays.stream(records).forEach(record -> {
            String[] info = record.split(" ");
            if (info[2].equals("IN")) {
                time.put(info[1], getTime(info[0]));
            } else {
                answer.put(info[1], answer.getOrDefault(info[1], 0) + getTime(info[0]) - time.get(info[1]));
                time.remove(info[1]);
            }
        });
        time.keySet().forEach(k -> answer.put(k, answer.getOrDefault(k, 0) + 60 * 24 - 1 - time.get(k)));
        return answer.values().stream().mapToInt(this::calc).toArray();
    }

    private Integer calc(int time) {
        if (time <= fees[0]) return fees[1];
        time -= fees[0];
        int cnt = (time % fees[2] == 0 ? 0 : 1) + time / fees[2];
        return cnt * fees[3] + fees[1];
    }

    private Integer getTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}