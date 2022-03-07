package com.codingtest.algorithm.acmicpc.q1245;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visit;
    static int n, m;
    static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static final int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};

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

        visit = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) continue;
                if(bfs(i, j)) ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean bfs(int x, int y) {
        boolean find = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, board[x][y]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if (!isValidRange(nextX, nextY)) continue;
                if (poll[2] < board[nextX][nextY]) find = false;
                if (visit[nextX][nextY] || poll[2] != board[nextX][nextY]) continue;
                int[] next = {nextX, nextY, board[nextX][nextY]};
                visit[nextX][nextY] = true;
                queue.offer(next);
            }
        }
        return find;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
