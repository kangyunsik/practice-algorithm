package com.codingtest.algorithm.programmers.q72414;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long max;
        int answer = 0;
        int pTime = decode(play_time);
        int aTime = decode(adv_time);
        int[] delta = new int[pTime + 2];
        long[] cur = new long[pTime + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            delta[decode(split[0])]++;
            delta[decode(split[1])]--;
        }

        cur[0] = delta[0];
        for (int i = 1; i <= pTime; i++) {
            cur[i] = cur[i - 1] + delta[i];
        }

        long expect = 0L;
        for (int i = 0; i < aTime; i++) {
            expect += cur[i];
        }
        max = expect;
        for (int i = 1; i + aTime <= pTime; i++) {
            expect += cur[i - 1 + aTime] - cur[i - 1];
            if (max < expect) {
                answer = i;
                max = expect;
            }
        }
        return String.format("%02d:%02d:%02d", answer / 3600, (answer / 60) % 60, answer % 60);
    }

    int decode(String time) {
        String[] temp = time.split(":");
        int ret = 0;
        for (int i = 0; i < 3; i++, ret *= 60) {
            ret += Integer.parseInt(temp[i]);
        }
        return ret / 60;
    }
}