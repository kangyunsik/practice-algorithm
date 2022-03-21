package com.codingtest.algorithm.acmicpc.q11060;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] input, dp;
    static int n;
    static final int INF = 1 << 10;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        dp = new int[n];
        Arrays.fill(dp, -1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int ans = find(0);
        if(ans == INF) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int find(int cur) {
        if (cur == n - 1) return 0;
        if (dp[cur] != -1) return dp[cur];
        int ret = INF;
        for (int i = 1; i <= input[cur] && cur + i < n; i++) {
            ret = Math.min(ret, find(cur + i) + 1);
        }
        return dp[cur] = ret;
    }
}
