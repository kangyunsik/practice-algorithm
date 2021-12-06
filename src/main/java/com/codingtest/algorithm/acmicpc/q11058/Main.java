package com.codingtest.algorithm.acmicpc.q11058;

import java.io.*;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new long[101];
        bw.write(getDP(n)+"\n");
        bw.flush();
    }

    private static long getDP(int index){
        if(dp[index] != 0) return dp[index];
        if(index < 6) return dp[index] = index;

        long max = 0;
        for (int i = 0; i < index-1; i++) {
            long pre = getDP(i);
            long post = getDP(index - 2 - i);
            max = Long.max(max, pre * (post+1));
        }
        return dp[index] = max;
    }
}
