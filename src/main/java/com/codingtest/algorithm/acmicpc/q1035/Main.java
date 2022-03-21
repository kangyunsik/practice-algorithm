package com.codingtest.algorithm.acmicpc.q1035;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board = new char[5][];
    static boolean[] nearSet = new boolean[1 << 25];
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static final int[] dx = {5, -5, 1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int status = 0;
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                status <<= 1;
                if (board[i][j] == '*') {
                    status++;
                    cnt++;
                }
            }
        }
        for (int i = 0; i < 1 << 25; i++) {
            if (Integer.bitCount(i) != cnt) continue;
            if (isNearStatus(i)) {
                nearSet[i] = true;
            }
        }

        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{status, 0});
        boolean[] visit = new boolean[1 << 25];
        visit[status] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curStatus = poll[0];
            int cost = poll[1];
            if (nearSet[curStatus]) {
                ans = cost;
                break;
            }

            for (int i = 0; i < 25; i++) {
                if ((curStatus & 1 << i) == 0) continue;
                for (int j = 0; j < 4; j++) {
                    int nextBit = i + dx[j];
                    if (isValidRange2(j, nextBit)) continue;
                    if ((curStatus & 1 << nextBit) > 0) continue;
                    int nextStatus = curStatus | (1 << nextBit);
                    nextStatus -= (1 << i);
                    if (visit[nextStatus]) continue;
                    visit[nextStatus] = true;
                    queue.offer(new int[]{nextStatus, cost + 1});
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean isValidRange2(int j, int nextBit) {
        if (nextBit < 0 || nextBit >= 25) return true;
        if (nextBit % 5 == 0 && j == 2) return true;
        if (nextBit % 5 == 4 && j == 3) return true;
        return false;
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < 5 && c < 5;
    }

    private static boolean isNearStatus(int status) {
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (status % 2 == 1) {
                    temp[i][j]++;
                }
                status >>= 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (temp[i][j] == 1) {
                    return bfs(temp, i, j) == cnt;
                }
            }
        }
        return false;
    }

    private static int bfs(int[][] temp, int r, int c) {
        int ret = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        boolean[][] visit = new boolean[5][5];
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = poll[0] + dr[i];
                int nextC = poll[1] + dc[i];
                if (!isValidRange(nextR, nextC) || visit[nextR][nextC] || temp[nextR][nextC] == 0) continue;
                ret++;
                visit[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC});
            }
        }
        return ret;
    }
}
