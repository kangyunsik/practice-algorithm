package com.codingtest.algorithm.acmicpc.q1914;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static String[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new String[4][4][n + 1];
        String cnt = String.valueOf(BigInteger.TWO.pow(n).subtract(BigInteger.ONE));
        if(n > 20){
            bw.write(cnt);
            bw.flush();
            return;
        }
        String ans = hanoi(1, 3, n);
        bw.write(cnt + "\n");
        bw.write(ans);
        bw.flush();
    }

    private static String hanoi(int from, int to, int height) {
        if (dp[from][to][height] != null) return dp[from][to][height];
        StringBuilder sb = new StringBuilder();
        if (height == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return dp[from][to][height] = sb.toString();
        }
        int another = 6 - from - to;
        sb.append(hanoi(from, another, height - 1));
        sb.append(hanoi(from, to, 1));
        sb.append(hanoi(another, to, height - 1));
        return dp[from][to][height] = sb.toString();
    }
}
