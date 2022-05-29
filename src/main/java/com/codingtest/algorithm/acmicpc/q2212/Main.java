package com.codingtest.algorithm.acmicpc.q2212;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static long[][] dp;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new long[n][k];
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp[n - 1], 0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(find(0, k - 1));
    }

    private static long find(int cur, int remain) {
        if (remain < 0) return INF;
        if (dp[cur][remain] != -1) return dp[cur][remain];

        long normalCase = find(cur + 1, remain);
        if (normalCase != INF) normalCase += (arr[cur + 1] - arr[cur]);
        long jumpCase = find(cur + 1, remain - 1);
        return dp[cur][remain] = Math.min(normalCase, jumpCase);
    }
}