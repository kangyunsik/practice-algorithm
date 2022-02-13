package com.codingtest.algorithm.acmicpc.q2012;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(values);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += Math.abs(values[i-1] - i);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
