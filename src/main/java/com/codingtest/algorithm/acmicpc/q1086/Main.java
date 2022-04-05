package com.codingtest.algorithm.acmicpc.q1086;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger[] input;
    static long[][] dp;
    static int n, k;
    static int[] tenValue, remain, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new BigInteger[n];
        String temp;
        len = new int[n];
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            len[i] = temp.length();
            input[i] = new BigInteger(temp, 10);
        }
        k = Integer.parseInt(br.readLine());

        init();
        simulateDP();

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        long able = dp[(1 << n) - 1][0];
        long gcd = getGCD(able, fact);
        System.out.println((able / gcd) + "/" + (fact / gcd));
    }

    private static long getGCD(long able, long fact) { // able <= fact
        if (able == 0) return fact;
        if (fact % able == 0) return able;
        return getGCD(fact % able, able);
    }

    private static void simulateDP() {
        dp = new long[1 << n][k];
        dp[0][0] = 1;
        for (int status = 0; status < 1 << n; status++) {
            for (int i = 0; i < n; i++) {
                if ((status & 1 << i) > 0) continue;
                int nextStatus = status | 1 << i;
                for (int j = 0; j < k; j++) {
                    int nextRemain = (j * tenValue[len[i]] + remain[i]) % k;
                    dp[nextStatus][nextRemain] += dp[status][j];
                }
            }
        }
    }

    private static void init() {
        tenValue = new int[51];
        tenValue[0] = 1;
        if (k == 1) tenValue[0] = 0;
        for (int i = 1; i <= 50; i++) {
            tenValue[i] = (tenValue[i - 1] * 10) % k;
        }
        BigInteger MOD = BigInteger.valueOf(k);
        remain = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = (int) input[i].mod(MOD).longValue();
        }
    }
}
