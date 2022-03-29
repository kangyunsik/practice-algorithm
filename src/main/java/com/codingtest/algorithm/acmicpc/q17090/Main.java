package com.codingtest.algorithm.acmicpc.q17090;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] board;
    static int[][] visit; // -1: cycle , 0: not-visit, 1: escape available
    static int ans, n, m;
    static final char[] dirMapper = new char[100];
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n];
        visit = new int[n][m];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['D'] = 2;
        dirMapper['L'] = 3;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] != 0) continue;
                find(i, j, 0);
            }
        }
        ans = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == -1) ans--;
            }
        }
        System.out.println(ans);
    }

    private static int find(int r, int c, int depth) {
        if (isInvalidRange(r, c)) return 1;
        if (visit[r][c] != 0) return visit[r][c];
        visit[r][c] = -1;
        int dir = dirMapper[board[r].charAt(c)];
        return visit[r][c] = find(r + dr[dir], c + dc[dir], depth + 1);
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
