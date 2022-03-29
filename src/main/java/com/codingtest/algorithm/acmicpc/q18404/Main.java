package com.codingtest.algorithm.acmicpc.q18404;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int curX = Integer.parseInt(st.nextToken()) - 1;
        int curY = Integer.parseInt(st.nextToken()) - 1;
        queue.offer(new int[]{curX, curY, 0});

        int[][] loc = new int[n][n];
        for (int i = 0, x, y; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            loc[x][y] = i + 1;
        }

        int remain = m;
        int[] ans = new int[m + 1];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int dist = pos[2];
            if (loc[x][y] > 0) {
                ans[loc[x][y]] = dist;
                if(--remain == 0){
                    break;
                }
            }

            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (isInvalidRange(nextX, nextY)) continue;
                if (visit[nextX][nextY]) continue;
                visit[nextX][nextY] = true;
                board[nextX][nextY] = dist + 1;
                queue.offer(new int[]{nextX, nextY, dist + 1});
            }
        }
        for (int i = 1; i <= m; i++) {
            sb.append(ans[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
