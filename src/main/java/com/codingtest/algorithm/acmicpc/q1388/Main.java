package com.codingtest.algorithm.acmicpc.q1388;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        boolean[][] visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                ans++;
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    int dir;
                    if (board[x][y] == '-') dir = 0;
                    else dir = 1;
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (isInvalidRange(nx, ny) || board[nx][ny] != board[x][y] || visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}