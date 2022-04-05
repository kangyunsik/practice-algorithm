package com.codingtest.algorithm.acmicpc.q17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static final int INF = 1 << 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n][3][3]; // depth, color, startWith
        int[][] input = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0][i], INF);
        }
        dp[0][0][0] = input[0][0];
        dp[0][1][1] = input[0][1];
        dp[0][2][2] = input[0][2];

        for (int startColor = 0; startColor < 3; startColor++) {
            for (int depth = 1; depth < n; depth++) {
                dp[depth][0][startColor] = Math.min(dp[depth - 1][1][startColor], dp[depth - 1][2][startColor]) + input[depth][0];
                dp[depth][1][startColor] = Math.min(dp[depth - 1][0][startColor], dp[depth - 1][2][startColor]) + input[depth][1];
                dp[depth][2][startColor] = Math.min(dp[depth - 1][0][startColor], dp[depth - 1][1][startColor]) + input[depth][2];
            }
        }
        int ans = INF;
        ans = Math.min(ans, Math.min(dp[n - 1][1][0], dp[n - 1][2][0]));
        ans = Math.min(ans, Math.min(dp[n - 1][0][1], dp[n - 1][2][1]));
        ans = Math.min(ans, Math.min(dp[n - 1][0][2], dp[n - 1][1][2]));
        System.out.println(ans);
    }
}
