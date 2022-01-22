package com.codingtest.algorithm.programmers.q17678;

import java.util.PriorityQueue;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int upper = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            int encodedTime = encode(time);
            pq.offer(encodedTime);
        }

        int cnt = 0;
        while (cnt < n) {
            int begin = 540 + cnt * t;
            for (int i = 0; i < m; i++) {
                if(pq.isEmpty() || pq.peek() > begin){
                    upper = begin;
                    break;
                }else{
                    upper = pq.poll() - 1;
                }
            }
            cnt++;
        }

        return decode(upper);
    }

    private int encode(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));
        return hour * 60 + min;
    }

    private String decode(int time) {
        int iHour = time / 60;
        int iMin = time % 60;
        return (iHour < 10 ? "0" + iHour : iHour) + ":" + (iMin < 10 ? "0" + iMin : iMin);
    }
}