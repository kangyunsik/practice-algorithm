package com.codingtest.algorithm.acmicpc.q16194;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        values = new int[n];
        dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(getDP(n)));
        bw.flush();
    }

    private static int getDP(int n) {
        if (n == 0 || dp[n] != 0) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, getDP(n - i) + values[i - 1]);
        }
        return dp[n] = min;
    }
}
