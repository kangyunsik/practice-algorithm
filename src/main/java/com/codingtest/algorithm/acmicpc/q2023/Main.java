package com.codingtest.algorithm.acmicpc.q2023;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] pow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        setPow();
        int maxBound = (int) Math.pow(10, n);
        for (int i = maxBound / 10; i < maxBound; i++) {
            if (isFitCondition(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void setPow() {
        pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 10;
        }
    }

    private static boolean isFitCondition(int v) {
        int target;
        for (int idx = 0; idx < n; idx++) {
            target = (v / pow[n - 1 - idx]);
            if (!isPrime(target)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int v) {
        int sq = (int) Math.sqrt(v);
        for (int i = 2; i <= sq; i++) {
            if (v % i == 0) return false;
        }
        return v > 1;
    }
}