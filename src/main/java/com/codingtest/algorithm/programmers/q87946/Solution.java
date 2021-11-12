package com.codingtest.algorithm.programmers.q87946;

import java.util.*;

class Solution {
    List<Integer[]> list = new ArrayList<>();
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int[] seq = new int[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            seq[i] = i;
        }
        permute(seq,0);
        for (Integer[] code : list) {
            calc(code, dungeons, k);
        }
        return answer;
    }

    private void calc(Integer[] code, int[][] d, int remain){
        int count = 0;
        for (Integer i : code) {
            if(d[i][0] <= remain){
                count++;
                remain -= d[i][1];
            }
        }
        answer = Math.max(count,answer);
    }

    private void permute(int[] seq , int depth){
        if(depth == seq.length){
            Integer[] ints = new Integer[seq.length];
            for (int i = 0; i < seq.length; i++) {
                ints[i] = seq[i];
            }
            list.add(ints);
        }

        for (int i = depth; i < seq.length; i++) {
            swap(seq, i, depth);
            permute(seq,depth+1);
            swap(seq, i, depth);
        }
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}