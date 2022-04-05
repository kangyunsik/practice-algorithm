package com.codingtest.algorithm.acmicpc.q1285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1 << n][n];

        for (int i = 0, line; i < n; i++) {
            line = 0;
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                line <<= 1;
                if (input.charAt(j) == 'T') line++;
            }
            for (int status = 0; status < 1 << n; status++) {
                for (int j = 0; j < n; j++) {
                    if ((status & 1 << j) == 0) continue;
                    line ^= 1 << j;
                }
                int bitCnt = Integer.bitCount(line);
                dp[status][i] = Math.min(bitCnt, n - bitCnt);
                for (int j = 0; j < n; j++) {
                    if ((status & 1 << j) == 0) continue;
                    line ^= 1 << j;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int status = 0; status < 1 << n; status++) {
            int temp = 0;
            for (int t : dp[status]) temp += t;
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);
    }
}
