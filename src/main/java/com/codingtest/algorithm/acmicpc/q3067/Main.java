package com.codingtest.algorithm.acmicpc.q3067;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int target = Integer.parseInt(br.readLine());
            dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                int coin = Integer.parseInt(st.nextToken());
                for (int j = 0; j <= target - coin; j++) {
                    dp[j + coin] += dp[j];
                }
            }
            sb.append(dp[target]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
