package com.codingtest.algorithm.acmicpc.q2133;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            bw.write("0\n");
        } else {
            dp = new int[31];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            bw.write(getAnswer(n) + "\n");
        }
        bw.flush();
    }

    private static int getAnswer(int n) {
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int ret = 0;
        ret += getAnswer(n - 2) * 3;
        for (int i = 4; n - i >= 0; i += 2) {
            ret += getAnswer(n - i) * 2;
        }
        return dp[n] = ret;
    }
}
