package com.codingtest.algorithm.acmicpc.q2624;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int money = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int coin, cnt;
        int[] dp = new int[money + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coin = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            for (int j = money; j >= 0; j--) {
                for (int k = 1; k <= cnt && j + coin * k <= money; k++) {
                    dp[j + coin * k] += dp[j];
                }
            }
        }
        System.out.println(dp[money]);
    }
}
