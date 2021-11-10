package com.codingtest.algorithm.programmers.q43238;

class Solution {
    public long solution(int n, int[] times) {
        long start = 0L, end = Long.MAX_VALUE;
        while(start < end){
            long temp = 0L;
            long mid = (start + end)/2;
            for (int time : times) {
                temp += mid/time;
            }

            if(temp >= n){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}