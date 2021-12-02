package com.codingtest.algorithm.acmicpc.q1937;

import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int[][] map;
    static int n;
    static final int[] dx = {0, 1, -1, 0};
    static final int[] dy = {1, 0, 0, -1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Integer.max(answer, dp(i, j));
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

    private static int dp(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];

        int max = 1;
        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (inRange(px, py) && map[x][y] < map[px][py]) {
                max = Integer.max(max, 1 + dp(px, py));
            }
        }
        return dp[x][y] = max;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}