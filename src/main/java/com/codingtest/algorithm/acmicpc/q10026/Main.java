package com.codingtest.algorithm.acmicpc.q10026;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/***
 *  소요시간 : 104 ms
 *  메모리사용량 : 13,508 KB
 */
public class Main {
    static char[][] board;
    static boolean[][] isVisit;
    static int n;

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int nonDisabled = getAreaCountByWhetherDisabled(false);
        int disabled = getAreaCountByWhetherDisabled(true);

        bw.append(String.valueOf(nonDisabled)).append(" ").append(String.valueOf(disabled));
        bw.flush();
    }

    private static int getAreaCountByWhetherDisabled(boolean isDisabled) {
        int nonDisabled = 0;
        isVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisit[i][j]) continue;
                bfs(i, j, isDisabled);
                nonDisabled++;
            }
        }
        return nonDisabled;
    }

    private static void bfs(int x, int y, boolean isDisabled) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            for (int i = 0; i < 4; i++) {
                int px = x + dx[i];
                int py = y + dy[i];
                if (isNotInRange(px, py) || isVisit[px][py]) continue;
                if (!isEqualByDisabled(board[px][py], board[x][y], isDisabled)) continue;
                isVisit[px][py] = true;
                queue.offer(new int[]{px, py});
            }
        }
    }

    private static boolean isEqualByDisabled(char c1, char c2, boolean isDisabled) {
        if (!isDisabled) return c1 == c2;
        if (c1 == c2) return true;
        return Math.abs(c1 - c2) == Math.abs('R' - 'G');
    }

    private static boolean isNotInRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
