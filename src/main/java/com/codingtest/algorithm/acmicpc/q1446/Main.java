package com.codingtest.algorithm.acmicpc.q1446;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer>[] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new Map[d + 1];
        dp = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            map[i] = new HashMap<>();
        }

        int a, b, c;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (b > d) continue;
            map[b].put(a, Math.min(map[b].getOrDefault(a, Integer.MAX_VALUE), c));
        }
        int ans = getDP(d);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getDP(int cur) {
        if (cur == 0) return 0;
        if (dp[cur] != 0) return dp[cur];
        int ret = getDP(cur - 1) + 1;
        for (int begin : map[cur].keySet()) {
            ret = Math.min(ret, getDP(begin) + map[cur].get(begin));
        }
        return dp[cur] = ret;
    }
}
