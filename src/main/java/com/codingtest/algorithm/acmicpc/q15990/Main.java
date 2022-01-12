package com.codingtest.algorithm.acmicpc.q15990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int mod = 1000000009;
        int ans, n, t = Integer.parseInt(br.readLine());
        int[][] dp = new int[100001][3];
        dp[1][0] = dp[2][1] = dp[3][2] = dp[3][0] = dp[3][1] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % mod;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % mod;
        }
        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            ans = (dp[n][0] + dp[n][1]) % mod + dp[n][2];
            ans %= mod;
            bw.write(ans + "\n");
            bw.flush();
        }

    }
}
