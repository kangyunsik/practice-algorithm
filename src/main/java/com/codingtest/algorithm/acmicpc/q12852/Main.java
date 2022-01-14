package com.codingtest.algorithm.acmicpc.q12852;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        prev = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;
            if(i%2==0){
                if(dp[i] > dp[i/2]+1){
                    prev[i] = i/2;
                    dp[i] = dp[i/2]+1;
                }
            }
            if(i%3==0){
                if(dp[i] > dp[i/3]+1){
                    prev[i] = i/3;
                    dp[i] = dp[i/3]+1;
                }
            }
        }
        bw.write((dp[n]-1)+"\n");
        int cur = n;
        while(cur != 1){
            bw.write(cur+" ");
            cur = prev[cur];
        }
        bw.write("1\n");
        bw.flush();
    }
}
