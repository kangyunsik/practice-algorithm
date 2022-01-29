package com.codingtest.algorithm.programmers.q92342;

import java.util.Arrays;

class Solution {
    int[] info;
    int[] answer = new int[]{-1};
    int max = 0;

    public int[] solution(int n, int[] info) {
        this.info = info;
        findCases(new int[11], n, 0);
        return answer;
    }

    private void findCases(int[] rian, int remain, int cur) {
        if (cur > 10) {
            if (remain != 0) return;
            calc(rian);
            return;
        }

        for (int i = 0; i <= remain; i++) {
            rian[cur] += i;
            findCases(rian, remain - i, cur + 1);
            rian[cur] -= i;
        }
    }

    private void calc(int[] rian) {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            if (rian[i] > info[i]) {
                sum += 10 - i;
            } else if(info[i] > 0){
                sum -= 10 - i;
            }
        }
        if(sum <= 0) return;
        if (sum > max) {
            max = sum;
            answer = Arrays.copyOf(rian, 11);
        } else if (sum == max) {
            for (int i = 10; i >= 0; i--) {
                if(answer[i] < rian[i]){
                    answer = Arrays.copyOf(rian, 11);
                    break;
                }else if(answer[i] > rian[i]){
                    break;
                }
            }
        }
    }
}