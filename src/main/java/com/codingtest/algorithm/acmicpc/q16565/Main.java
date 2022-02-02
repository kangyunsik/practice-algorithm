package com.codingtest.algorithm.acmicpc.q16565;

import java.io.*;

public class Main {
    static final int bound = (int) Math.pow(2, 13);
    static int[][] combMem;
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        combMem = new int[27][27];
        int ans = 0;
        for (int a = 0; a < bound; a++) {
            for (int b = 0; b < bound; b++) {
                int a1 = Integer.bitCount(a);
                int b1 = Integer.bitCount(b);
                int zero = 26 - (a1 + b1);
                int one = n - 2 * (a1 + b1);
                if ((a & b) > 0 && one <= zero && one >= 0) {
                    ans += comb(zero, one) * ((1 << one) % mod);
                    ans %= mod;
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int comb(int p, int q) {
        if(combMem[p][q] != 0) return combMem[p][q];
        if (p / 2 < q) return comb(p, p - q);
        long temp = 1L;
        for (int i = 0; i < q; i++) {
            temp *= p - i;
        }
        for (int i = 1; i <= q; i++) {
            temp /= i;
        }
        return (combMem[p][q] = (int)temp % mod);
    }
}
