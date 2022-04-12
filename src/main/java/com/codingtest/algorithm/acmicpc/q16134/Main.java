package com.codingtest.algorithm.acmicpc.q16134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000007;
    static long[] fact = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getFact();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long ans = getCombi(n, r);
        System.out.println(ans);
    }

    private static long getCombi(int n, int r) {
        long a = fact[n];
        long b = power(fact[n - r], MOD - 2);
        long c = power(fact[r], MOD - 2);
        return (((a * b) % MOD) * c) % MOD;
    }

    private static long power(long n, int i) {
        long x = n;
        long ret = 1;
        while (i > 0) {
            if (i % 2 == 1) {
                ret *= x;
                ret %= MOD;
            }
            x *= x;
            x %= MOD;
            i >>= 1;
        }
        return ret;
    }

    private static void getFact() {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            fact[i] = fact[i - 1] * i;
            fact[i] %= MOD;
        }
    }
}