package com.codingtest.algorithm.programmers.q43238;

class Solution {
    public long solution(int n, int[] times) {
        long start = 0L, end = 0L, ans = Long.MAX_VALUE;
        for(int time : times){
            end = Long.max(end, (long)time * n);
        }

        while(start <= end){
            long temp = 0L;
            long mid = (start + end)/2;
            for (int time : times) {
                temp += mid/time;
            }

            if(temp >= n){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}