package com.codingtest.algorithm.acmicpc.q1965;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] inputs = new int[n];
        int[][] dp = new int[1001][n];
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            inputs[i] = input;
            dp[input][i] = 1;
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 1000; j++) {
                int max = 0;
                for (int k = 1; k < j; k++) {
                    max = Math.max(max, dp[k][i - 1]);
                }
                dp[j][i] += max;
                dp[j][i] = Math.max(dp[j][i], dp[j][i-1]);
                ans = Math.max(ans, dp[j][i]);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
