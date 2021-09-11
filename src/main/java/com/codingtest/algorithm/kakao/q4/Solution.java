package com.codingtest.algorithm.kakao.q4;

public class Solution {
    public int[] solution(int n, int[] info) {
        double[] average = new double[11];
        int[] answer = new int[11];
        int nam = n;
        for (int i = 0; i < 11; i++) {
            if(info[i] == 0)
                average[i] = (10-i) / (info[i]+1);
            else
                average[i] = (10-i) * 2 / (info[i]+1);
        }

        boolean[] check = new boolean[11];
        int count = 200;
        while(true){
            double max = -1000;
            int max_i = -1;
            for (int i = 0; i < 11; i++) {
                if(!check[i] && max < average[i] && nam -1 > info[i]){
                    max = average[i];
                    max_i = i;
                    check[i] = true;
                }
            }
            count--;

            if(max_i == -1)
                break;
            if(count < 0)
                break;
            else {
                answer[max_i] = info[max_i] + 1;
                nam -= info[max_i] + 1;
            }
        }

        if(getPoint(answer,info) > 0)
            return answer;
        else
            return new int[]{-1};
    }

    private int getPoint(int[] answer, int[] info) {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            if(info[i] < answer[i]){
                sum += 10-i;
            }
        }
        return sum;
    }
}
