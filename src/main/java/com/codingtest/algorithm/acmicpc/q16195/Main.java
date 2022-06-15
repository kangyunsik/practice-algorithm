package com.codingtest.algorithm.acmicpc.q16195;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dp;
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        dp = new int[1001][1001];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= 1000; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(find(n, m)).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int cur, int depth) {
        if (depth < 0 || cur < 0) return 0;
        if (dp[cur][depth] != -1) return dp[cur][depth];
        return dp[cur][depth] = ((find(cur - 1, depth - 1)
                + find(cur - 2, depth - 1)) % MOD
                + find(cur - 3, depth - 1)) % MOD;
    }
}