package com.codingtest.algorithm.acmicpc.q11049;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        values = new int[n][2];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            values[i][0] = Integer.parseInt(st.nextToken());
            values[i][1] = Integer.parseInt(st.nextToken());
        }
        int ans = getDP(0,n-1);
        bw.write(ans+"\n");
        bw.flush();
    }

    private static int getDP(int s, int e){
        if(dp[s][e] != 0) return dp[s][e];
        if(s == e) return 0;

        int min = Integer.MAX_VALUE;
        int sum;

        for (int m = s; m < e; m++) {
            sum = getDP(s,m) + getDP(m+1,e) +values[s][0] * values[m][1] * values[e][1];
            min = Math.min(sum,min);
        }
        return dp[s][e] = min;
    }
}
