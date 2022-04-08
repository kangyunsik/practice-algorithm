package com.codingtest.algorithm.acmicpc.q1563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][][] dp;
    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2][3];
        Arrays.fill(dp[0][0], 0);
        Arrays.fill(dp[0][1], 0);
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans += getDP(n, i, j);
                ans %= MOD;
            }
        }
        System.out.println(ans);
    }

    private static int getDP(int n, int l, int a) {
        if (dp[n][l][a] != -1) return dp[n][l][a];
        int ret = 0;
        if (a > 0) {
            ret += getDP(n - 1, l, a - 1);
        } else {
            for (int i = 0; i <= l; i++) {
                for (int j = 0; j < 3; j++) {
                    ret += getDP(n - 1, i, j);
                }
            }
            ret %= MOD;
        }
        return dp[n][l][a] = ret;
    }
}
