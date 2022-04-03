package com.codingtest.algorithm.acmicpc.q1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] dp = new int[100];
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st2.nextToken());
            for (int j = 99; j >= weight; j--) {
                dp[j] = Math.max(dp[j - weight] + value, dp[j]);
            }
        }
        System.out.println(dp[99]);
    }
}
