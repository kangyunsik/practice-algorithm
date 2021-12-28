package com.codingtest.algorithm.acmicpc.q15817;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, x;
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = x - 1; j >= 0; j--) {
                if (dp[j] != 0) {
                    for (int k = 1; k <= b && j + k * a <= x; k++) {
                        dp[j + k * a] += dp[j];
                    }
                }
            }
        }
        bw.write(dp[x] + "\n");
        bw.flush();
    }
}
