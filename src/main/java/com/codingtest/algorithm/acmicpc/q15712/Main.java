package com.codingtest.algorithm.acmicpc.q15712;

import java.util.Scanner;

public class Main {

    static long mod;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, r, n;
        a = sc.nextInt();
        r = sc.nextInt();
        n = sc.nextInt();
        mod = sc.nextInt();
        System.out.println((a * getSolution(r, n)) % mod);
    }

    private static long pow(long r, long n) {
        long temp = 1L;
        while (n > 0) {
            if (n % 2 == 1) {
                temp *= r;
                temp %= mod;
            }
            r *= r;
            r %= mod;
            n /= 2;
        }
        return temp;
    }

    private static long getSolution(long r, long n) {
        if (mod == 1) return 0;
        if (n == 1) return 1;

        long temp;
        if (n % 2 == 1) {
            temp = 1 + (r * getSolution(r, n / 2)) % mod * (1 + pow(r, n / 2));
        }else{
            temp = getSolution(r, n/2) * (1 + pow(r, n/2));
        }
        return temp % mod;
    }

}
