package com.codingtest.algorithm.acmicpc.q1311;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[(1 << n) - 1] = 0;
        System.out.println(find(0, 0));
    }

    private static int find(int cur, int status) {
        if (dp[status] != -1) return dp[status];
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((status & 1 << i) > 0) continue;
            ret = Math.min(ret, find(cur + 1, status | 1 << i) + arr[cur][i]);
        }
        return dp[status] = ret;
    }
}
