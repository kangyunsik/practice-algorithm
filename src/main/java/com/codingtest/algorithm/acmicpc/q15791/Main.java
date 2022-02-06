package com.codingtest.algorithm.acmicpc.q15791;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long temp = 1;
        for (int i = n; i > n - m; i--) {
            temp *= i;
            temp %= mod;
        }
        for (int i = 1; i <= m; i++) {
            temp *= myPow(i, mod - 2);
            temp %= mod;
        }
        bw.write(temp + "\n");
        bw.flush();
    }

    private static int myPow(int b, int e) {
        long ret = 1;
        long x = b;
        while (e > 0) {
            if (e % 2 == 1) {
                ret *= x;
                ret %= mod;
            }
            x *= x;
            x %= mod;
            e /= 2;
        }
        return (int) ret;
    }
}
