package com.codingtest.algorithm.acmicpc.q13977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] fact = new long[4000001];
    static final int P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        initFact();
        for (int i = 0, n, k; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            sb.append(getComb(n, k)).append("\n");
        }
        System.out.println(sb);
    }

    private static void initFact() {
        fact[0] = fact[1] = 1L;
        for (int i = 2; i <= 4000000; i++) {
            fact[i] = (fact[i - 1] * i) % P;
        }
    }

    private static long pow(long a, int r) {
        long x = a;
        long ret = 1L;
        while (r > 0) {
            if (r % 2 == 1) {
                ret *= x;
                ret %= P;
            }
            x *= x;
            x %= P;
            r /= 2;
        }
        return ret;
    }

    private static long getComb(int n, int k) {
        long a = fact[n];
        long b = pow(fact[n - k], P - 2);
        long c = pow(fact[k], P - 2);
        return ((a * b) % P) * c % P;
    }

}
