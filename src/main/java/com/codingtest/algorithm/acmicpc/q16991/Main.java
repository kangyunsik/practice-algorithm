package com.codingtest.algorithm.acmicpc.q16991;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static double[][] dist;
    static double[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dist = new double[n][n];
        dp = new double[n][1 << n];
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                dist[i][j] = getDist(input[i], input[j]);
            }
        }

        bw.write(String.valueOf(findCases(1, 0)));
        bw.flush();
    }

    private static double findCases(int visit, int cur) {
        if (visit + 1 == (1 << n)) return dist[cur][0];
        if (dp[cur][visit] != 0) return dp[cur][visit];

        dp[cur][visit] = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((visit & (1 << i)) > 0 || dist[cur][i] == 0) continue;
            double cost = findCases(visit | (1 << i), i);
            dp[cur][visit] = Math.min(dp[cur][visit], dist[cur][i] + cost);
        }
        return dp[cur][visit];
    }

    private static double getDist(int[] pos1, int[] pos2) {
        double dx = pos1[0] - pos2[0];
        double dy = pos1[1] - pos2[1];
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
