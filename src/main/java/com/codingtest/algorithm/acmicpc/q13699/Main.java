package com.codingtest.algorithm.acmicpc.q13699;

import java.io.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        dp[0] = 1;
        long ans = getDP(n);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static long getDP(int n) {
        if(dp[n] != 0) return dp[n];
        long ret = 0;
        for (int i = 0; i < n; i++) {
            ret += getDP(i) * getDP(n - i - 1);
        }
        return dp[n] = ret;
    }
}
