package com.codingtest.algorithm.acmicpc.q17485;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[n + 1][m][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                dp[i][j][1] = input + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                dp[i][j][0] = dp[i][j][2] = INF;
                if (j > 0) dp[i][j][0] = input + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                if (j + 1 < m) dp[i][j][2] = input + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[n][i][j]);
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
