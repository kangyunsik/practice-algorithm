package com.codingtest.algorithm.acmicpc.q6087;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int R, C, n, m, endR, endC;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'C') {
                    endR = R;
                    endC = C;
                    R = i;
                    C = j;
                }
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.offer(new int[]{R, C, i, 0}); // x, y, dir, turnCnt
        }
        int[][] turnCnt = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(turnCnt[i], Integer.MAX_VALUE);
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = poll[0] + dr[i];
                int nextC = poll[1] + dc[i];
                if (isValidRange(nextR, nextC) && board[nextR][nextC] != '*') {
                    int nextTurnCnt = poll[3];
                    if (i != poll[2]) nextTurnCnt++;
                    if (turnCnt[nextR][nextC] < nextTurnCnt) continue;
                    turnCnt[nextR][nextC] = nextTurnCnt;
                    queue.offer(new int[]{nextR, nextC, i, nextTurnCnt});
                }
            }
        }
        return turnCnt[endR][endC];
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
