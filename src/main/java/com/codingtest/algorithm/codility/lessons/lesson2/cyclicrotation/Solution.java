package com.codingtest.algorithm.codility.lessons.lesson2.cyclicrotation;

class Solution {
    public int[] solution(int[] A, int K) {
        if(A.length == 0){
            return new int[]{};
        }

        int len = A.length;
        K %= len;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = A[(i + len - K) % len];
        }

        return result;
    }
}
