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

        int[] dp = new int[k + 1];
        int weight;
        int value;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            for (int j = k - weight; j >= 0; j--) {
                dp[j + weight] = Math.max(dp[j + weight], dp[j] + value);
            }
        }

        int ans = 0;
        for (int i : dp) ans = Math.max(ans, i);
        System.out.println(ans);
    }
}