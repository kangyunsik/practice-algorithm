package com.codingtest.algorithm.acmicpc.q6236;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long begin = max;
        long end = 10000 * 100000L;
        while (begin < end) {
            long mid = (begin + end) / 2;
            if (getMinPopCnt(arr, mid) <= m) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        System.out.println(end);
    }

    private static int getMinPopCnt(int[] arr, long cur) {
        int ret = 1;
        long cash = cur;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= cash){
                cash -= arr[i];
            }else{
                ret++;
                cash = cur - arr[i];
            }
        }
        return ret;
    }
}