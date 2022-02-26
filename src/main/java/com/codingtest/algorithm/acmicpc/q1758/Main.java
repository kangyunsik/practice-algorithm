package com.codingtest.algorithm.acmicpc.q1758;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(arr[n - 1 - i] - i, 0);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
