package com.codingtest.algorithm.programmers.q83201;

class Solution {
    public String solution(int[][] scores) {
        int n = scores.length;
        int sum, max, min, ad;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sum = ad = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int[] score : scores) {
                sum += score[i];
                if (max == score[i]) {
                    max = Integer.MAX_VALUE;
                } else if (max < score[i]) {
                    max = score[i];
                }

                if (min == score[i]) {
                    min = Integer.MIN_VALUE;
                } else if (min > score[i]) {
                    min = score[i];
                }
            }

            if (scores[i][i] == max) {
                ad++;
                sum -= max;
            } else if (scores[i][i] == min) {
                ad++;
                sum -= min;
            }

            if (sum >= 90 * (n - ad)) {
                sb.append("A");
            } else if (sum >= 80 * (n - ad)) {
                sb.append("B");
            } else if (sum >= 70 * (n - ad)) {
                sb.append("C");
            } else if (sum >= 50 * (n - ad)) {
                sb.append("D");
            } else {
                sb.append("F");
            }
        }

        return sb.toString();
    }
}