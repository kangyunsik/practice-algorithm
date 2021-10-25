package com.codingtest.algorithm.programmers.q42895;

class Solution {
    int N;
    int number;
    int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        this.N = N;
        this.number = number;
        recursive(N, 1);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void recursive(int value, int depth) {
        if(depth > 8 || depth > answer){
            return;
        }

        if(value == number){
            answer = Math.min(answer , depth);
            return;
        }

        int temp = N;
        for (int i = 1; i < 8; i++) {
            recursive(value + temp, depth+i);
            recursive(value - temp , depth+i);
            recursive(value * temp , depth+i);
            recursive(value / temp , depth+i);

            temp *= 10;
            temp += N;
            recursive(temp , depth+i);
        }
    }
}