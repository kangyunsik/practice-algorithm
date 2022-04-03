package com.codingtest.algorithm.acmicpc.q1516;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] cost;
    static List<Integer>[] required;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        cost = new int[n + 1];
        required = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            required[i] = new ArrayList<>();
        }
        for (int i = 1, r; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i] = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            while (r != -1) {
                required[i].add(r);
                r = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(find(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int find(int idx) {
        if(dp[idx] != 0) return dp[idx];
        int max = 0;
        for (int req : required[idx]) {
            max = Math.max(max, find(req));
        }
        return dp[idx] = max + cost[idx];
    }
}
