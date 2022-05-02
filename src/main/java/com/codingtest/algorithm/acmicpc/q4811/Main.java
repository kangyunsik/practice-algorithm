package com.codingtest.algorithm.acmicpc.q4811;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[31][31];
        Arrays.fill(dp[0], 1L);
        for (int i = 1; i <= 30; i++) {
            for (int j = i; j <= 30; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        int n = Integer.parseInt(br.readLine());
        while(n != 0){
            sb.append(dp[n][n]).append("\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}