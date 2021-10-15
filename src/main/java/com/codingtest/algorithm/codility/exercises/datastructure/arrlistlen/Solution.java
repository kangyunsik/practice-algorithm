package com.codingtest.algorithm.codility.exercises.datastructure.arrlistlen;

class Solution {
    public int solution(int[] A) {
        if(A.length == 0)
            return 0;

        int current = 0;
        int ans = 0;

        while(A[current] != -1){
            current = A[current];
            ans++;
        }

        return ans + 1;
    }
}
