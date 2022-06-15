package com.codingtest.algorithm.acmicpc.q20057;

import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[][] board;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static boolean[][] visit;

    // [0] = 진행 방향 기준, [1] = 수직 방향 상수, [2] = 퍼센트
    static final int[][] tornadoes = {
            {2, 0, 5},
            {1, 1, 10}, {1, -1, 10}, {0, 1, 7}, {0, -1, 7},
            {0, 2, 2}, {0, -2, 2}, {-1, 1, 1}, {-1, -1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int dir, int depth) {
        visit[r][c] = true;
        if (depth == n * n) {
            simulate(r - dr[dir], c - dc[dir], (dir + 2) % 4);
            return;
        }

        int nextDir = dir;
        int nr = r + dr[nextDir];
        int nc = c + dc[nextDir];
        if (isOutOfBound(nr, nc) || visit[nr][nc]) {
            nextDir = (nextDir + 1) % 4;
            nr = r + dr[nextDir];
            nc = c + dc[nextDir];
        }

        dfs(nr, nc, nextDir, depth + 1);
        if (!(r == 0 && c == 0)) {
            simulate(r - dr[dir], c - dc[dir], (dir + 2) % 4);
        }
    }

    private static void simulate(int r, int c, int dir) {
        int away = 0, nr, nc;
        for (int[] tornado : tornadoes) {
            nr = r + dr[dir] * tornado[0] + dr[(dir + 1) % 4] * tornado[1];
            nc = c + dc[dir] * tornado[0] + dc[(dir + 1) % 4] * tornado[1];
            int val = tornado[2] * board[r][c] / 100;
            away += val;
            if (isOutOfBound(nr, nc)) ans += val;
            else board[nr][nc] += val;
        }
        nr = r + dr[dir];
        nc = c + dc[dir];
        if (isOutOfBound(nr, nc)) ans += board[r][c] - away;
        else board[nr][nc] += board[r][c] - away;
        board[r][c] = 0;
    }

    private static boolean isOutOfBound(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}