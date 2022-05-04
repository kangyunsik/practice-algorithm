package com.codingtest.algorithm.acmicpc.q1509;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int len;
    static List<Integer>[] jump;
    static int[] dp;
    static final int INF = 1 << 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        init(input);
        System.out.println(getDP(0));
    }

    private static int getDP(int idx) {
        if (dp[idx] != INF) return dp[idx];
        int ca = getDP(idx + 1);
        for (int j : jump[idx]) {
            ca = Math.min(ca, getDP(idx + j + 1));
        }
        return dp[idx] = ca + 1;
    }

    private static void init(String input) {
        len = input.length();
        jump = new List[len];
        for (int i = 0; i < len; i++) {
            jump[i] = new ArrayList<>();
        }
        dp = new int[len + 1];
        Arrays.fill(dp, INF);
        dp[len] = 0;
        for (int i = 0; i < len; i++) {
            addJumpList(i, i, input);
            addJumpList(i, i + 1, input);
        }
    }

    private static void addJumpList(int l, int r, String input) {
        for (int left = l, right = r; left >= 0 && right < len; left--, right++) {
            if (input.charAt(left) != input.charAt(right)) {
                break;
            }
            jump[left].add(right - left);
        }
    }
}