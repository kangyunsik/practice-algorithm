package com.codingtest.algorithm.acmicpc.q2410;

import java.io.*;

public class Main {

    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int term = 1; term <= n; term <<= 1) {
            for (int i = 0; i + term <= n; i++) {
                dp[i + term] += dp[i];
                dp[i + term] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}