package com.codingtest.algorithm.acmicpc.q11689;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        List<Integer> primes = new ArrayList<>();

        setPrimes((int) Math.sqrt(n), primes);
        Map<Long, Integer> map = new HashMap<>();
        int primeIdx = 0;
        while (n != 1 && primeIdx < primes.size()) {
            int prime = primes.get(primeIdx);
            while (n % prime == 0) {
                map.put((long) prime, map.getOrDefault((long) prime, 0) + 1);
                n /= prime;
            }
            primeIdx++;
        }
        if (n != 1) {
            map.put(n, 1);
        }

        long ans = 1L;
        for (long key : map.keySet()) {
            int value = map.get(key);
            ans *= pow(key, value - 1) * (key - 1);
        }
        System.out.println(ans);
    }

    private static long pow(long n, int r) {
        long x = n;
        long ret = 1L;
        while (r > 0) {
            if (r % 2 == 1) {
                ret *= x;
            }
            x *= x;
            r /= 2;
        }
        return ret;
    }

    private static void setPrimes(int bound, List<Integer> primes) {
        boolean[] isPrime = new boolean[Math.max(2, bound + 1)];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= bound; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j <= bound; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }
    }
}