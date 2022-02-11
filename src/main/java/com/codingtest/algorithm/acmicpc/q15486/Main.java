package com.codingtest.algorithm.acmicpc.q15486;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] time;
    static int[] pred;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        time = new int[n];
        pred = new int[n];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            pred[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        if(time[0] <= n)
            dp[time[0]] = pred[0] + dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (time[i] + i <= n)
                dp[time[i] + i] = Math.max(dp[time[i] + i], pred[i] + dp[i]);
        }
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
