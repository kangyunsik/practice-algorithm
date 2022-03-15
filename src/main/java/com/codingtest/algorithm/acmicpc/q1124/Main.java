package com.codingtest.algorithm.acmicpc.q1124;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final int PRIME_CNT = 100000;
    static boolean[] isPrime = new boolean[PRIME_CNT];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        initPrimes();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime[getPrimeCnt(i)]) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void initPrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < PRIME_CNT; i++) {
            if (!isPrime[i]) continue;
            primes.add(i);
            for (int j = i * 2; j < PRIME_CNT; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private static int getPrimeCnt(int val) {
        int ret = 0;
        for (Integer prime : primes) {
            if (val < prime) return ret;
            while (val % prime == 0) {
                val /= prime;
                ret++;
            }
        }
        return ret;
    }
}
