package com.codingtest.algorithm.acmicpc.q1176;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] input;
    static int n, k;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        input = new int[n];
        dp = new long[n][1 << n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1L);
            dp[i][0] = 1L;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += find(i, (1 << n) - 1 - (1 << i));
        }
        System.out.println(ans);
    }

    private static long find(int idx, int status) {
        if (dp[idx][status] != -1L) return dp[idx][status];
        long ret = 0;
        for (int i = 0; i < n; i++) {
            if ((status & 1 << i) == 0) continue;
            if (Math.abs(input[idx] - input[i]) <= k) continue;
            ret += find(i, status ^ 1 << i);
        }
        return dp[idx][status] = ret;
    }
}
