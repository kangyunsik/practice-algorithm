package com.codingtest.algorithm.acmicpc.q13172;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int ni, si;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ni = Integer.parseInt(st.nextToken());
            si = Integer.parseInt(st.nextToken());
            sum += (getReverse(ni) * si) % MOD;
            sum %= MOD;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static long getReverse(int n) {
        long mul = MOD - 2;
        long x = n;
        long ret = 1;
        while (mul > 0) {
            if (mul % 2 == 1) {
                ret *= x;
                ret %= MOD;
            }
            x *= x;
            x %= MOD;
            mul /= 2;
        }
        return ret;
    }
}
