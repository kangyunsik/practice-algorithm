package com.codingtest.algorithm.acmicpc.q2342;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1000000000;
    static int[][][] dp;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int n = list.size() - 1;
        dp = new int[5][5][n + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        dp[0][0][0] = 0;

        for (int cur = 1; cur <= n; cur++) {
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    updateDP(l, r, cur);
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ans = Math.min(ans, dp[i][j][n]);
            }
        }
        System.out.println(ans);
    }

    private static void updateDP(int l, int r, int cur) {
        int np = list.get(cur - 1);
        if (np != r) {
            dp[np][r][cur] = Math.min(dp[0][r][cur - 1] + 2, dp[np][r][cur]);
            dp[np][r][cur] = Math.min(dp[getNext(np, 1)][r][cur - 1] + 3, dp[np][r][cur]);
            dp[np][r][cur] = Math.min(dp[getNext(np, -1)][r][cur - 1] + 3, dp[np][r][cur]);
            dp[np][r][cur] = Math.min(dp[getNext(np, 2)][r][cur - 1] + 4, dp[np][r][cur]);
        } else {
            dp[l][np][cur] = Math.min(dp[l][r][cur - 1] + 1, dp[np][r][cur]);
        }
        if (np != l) {
            dp[l][np][cur] = Math.min(dp[l][0][cur - 1] + 2, dp[l][np][cur]);
            dp[l][np][cur] = Math.min(dp[l][getNext(np, 1)][cur - 1] + 3, dp[l][np][cur]);
            dp[l][np][cur] = Math.min(dp[l][getNext(np, -1)][cur - 1] + 3, dp[l][np][cur]);
            dp[l][np][cur] = Math.min(dp[l][getNext(np, 2)][cur - 1] + 4, dp[l][np][cur]);
        } else {
            dp[np][r][cur] = Math.min(dp[l][r][cur - 1] + 1, dp[np][r][cur]);
        }
    }

    private static int getNext(int idx, int j) {
        return ((idx + j) + 3) % 4 + 1;
    }
}