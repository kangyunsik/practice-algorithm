package com.codingtest.algorithm.acmicpc.q16400;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer> primes = new ArrayList<>();
    private static int MOD = 123456789;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        setEratostenes(n);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (Integer prime : primes) {
            for (int i = prime; i <= n; i++) {
                dp[i] += dp[i - prime];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }

    private static void setEratostenes(int range) {
        boolean[] prime = new boolean[range + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= range; i++) {
            if (!prime[i]) continue;
            primes.add(i);
            for (int j = i * 2; j <= range; j += i) {
                prime[j] = false;
            }
        }

    }
}
