package com.codingtest.algorithm.acmicpc.q1016;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Long> set = new HashSet<>();
        List<Long> primes = new ArrayList<>();

        long min = sc.nextLong();
        long max = sc.nextLong();

        for (long i = 2; i * i <= max; i++) primes.add(i * i);

        for (long i = min; i <= max; i++) set.add(i);

        for (Long prime : primes) {
            long temp = (min / prime) * prime;
            if (min > temp || temp > max) {
                temp += prime;
            }

            for (long i = temp; i <= max; i += prime) {
                set.remove(i);
            }
        }

        System.out.println(set.size());
    }
}
