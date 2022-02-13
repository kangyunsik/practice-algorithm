package com.codingtest.algorithm.acmicpc.q10826;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger[] dp = new BigInteger[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
