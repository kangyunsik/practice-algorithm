package com.codingtest.algorithm.acmicpc.q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, k;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n][2];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = k - items[i][0]; j >= 0; j--) {
                if (dp[j] >= 0) {
                    dp[j + items[i][0]] = Math.max(dp[j + items[i][0]], dp[j] + items[i][1]);
                }
            }
        }

        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }
}