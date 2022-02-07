package com.codingtest.algorithm.acmicpc.q2098;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist, dp;
    static final int INF = 1000000000;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(findRoutes(0, 1) + "\n");
        bw.flush();
    }

    private static int findRoutes(int cur, int already) {
        if (already == (1 << n) - 1) {
            if (dist[cur][0] != 0)
                return dist[cur][0];
            return INF;
        }

        if (dp[cur][already] != 0) return dp[cur][already];
        int ret = INF;
        for (int i = 1; i < n; i++) {
            if ((already & (1 << i)) == 0 && dist[cur][i] != 0) {
                ret = Math.min(ret, dist[cur][i] + findRoutes(i, already + (1 << i)));
            }
        }
        return dp[cur][already] = ret;
    }
}
