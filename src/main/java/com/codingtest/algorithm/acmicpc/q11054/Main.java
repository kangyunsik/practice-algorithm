package com.codingtest.algorithm.acmicpc.q11054;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static int[] array;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[n][n + 1][2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, find(i));
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int find(int index){
        int left = helperLeft(0, index);
        int right = helperRight(index, array.length);
        return left + right;
    }

    private static int helperRight(int start, int end){
        List<Integer> list = new ArrayList<>();
        for (int i = end-1; i >= start ; i--) {
            int f = Collections.binarySearch(list, array[i]);
            if(f < 0 && array[i] < array[start]){
                f = -f-1;
                if(f == list.size()){
                    list.add(array[i]);
                }else{
                    list.set(f, array[i]);
                }
            }
        }
        return list.size() + 1;
    }

    private static int helperLeft(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            int f = Collections.binarySearch(list, array[i]);
            if(f < 0 && array[i] < array[end]){
                f = -f-1;
                if(f == list.size()){
                    list.add(array[i]);
                }else{
                    list.set(f, array[i]);
                }
            }
        }
        return list.size();
    }
}
