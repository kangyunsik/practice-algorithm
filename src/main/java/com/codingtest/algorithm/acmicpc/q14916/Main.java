package com.codingtest.algorithm.acmicpc.q14916;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static final int INF = 1 << 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        getDP(n);
        if(dp[n] >= INF) dp[n] = -1;
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }

    private static int getDP(int n) {
        if (n < 0) return INF;
        if (dp[n] != INF) return dp[n];
        return dp[n] = (Math.min(getDP(n - 5), getDP(n - 2))) + 1;
    }
}
