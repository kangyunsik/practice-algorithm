package com.codingtest.algorithm.programmers.q12945;

import java.util.Arrays;

class Solution {
    private static final int MOD = 1234567;
    int[] dp;
    public int solution(int n) {
        dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}