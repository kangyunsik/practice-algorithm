package com.codingtest.algorithm.acmicpc.q1926;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                cnt++;
                board[i][j] = 0;
                max = Math.max(max, bfs(i, j));
            }
        }
        bw.write(String.valueOf(cnt));
        bw.write("\n");
        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int ret = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            ret++;
            for (int k = 0; k < 4; k++) {
                int nextX = poll[0] + dx[k];
                int nextY = poll[1] + dy[k];
                if (!isValidRange(nextX, nextY) || board[nextX][nextY] == 0) continue;
                board[nextX][nextY] = 0;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return ret;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
