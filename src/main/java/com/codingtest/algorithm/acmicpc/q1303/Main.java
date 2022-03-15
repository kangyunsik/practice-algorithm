package com.codingtest.algorithm.acmicpc.q1303;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        boolean[][] visit = new boolean[n][m];
        int other = 0, our = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                char cur = board[i][j];
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                int cnt = 1;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextR = poll[0] + dr[k];
                        int nextC = poll[1] + dc[k];
                        if (!isValidRange(nextR, nextC) || visit[nextR][nextC] || board[nextR][nextC] != cur) continue;
                        visit[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                        cnt++;
                    }
                }
                if (cur == 'B') other += cnt * cnt;
                else our += cnt * cnt;
            }
        }
        bw.append(String.valueOf(our)).append(" ").append(String.valueOf(other));
        bw.flush();
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
