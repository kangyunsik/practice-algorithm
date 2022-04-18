package com.codingtest.algorithm.acmicpc.q2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        dp = new int[T + 1][2][R + 1];

        for (int i = 0, input; i < T; i++) {
            input = Integer.parseInt(br.readLine()) - 1;
            Arrays.fill(dp[i][input], 1);
            if (input == 1) dp[i][input][R] = 0;
        }

        for (int i = 1; i <= T; i++) {
            for (int r = 0; r < R; r++) {
                dp[i][0][r] += Math.max(dp[i - 1][0][r], dp[i - 1][1][r + 1]);
                dp[i][1][r] += Math.max(dp[i - 1][1][r], dp[i - 1][0][r + 1]);
            }
            dp[i][0][R] += dp[i - 1][0][R];
            dp[i][1][R] += dp[i - 1][1][R];
        }

        int ans = 0;
        for (int i = 0; i <= R; i++) {
            ans = Math.max(ans, dp[T][0][i]);
            ans = Math.max(ans, dp[T][1][i]);
        }
        System.out.println(ans);
    }
}
