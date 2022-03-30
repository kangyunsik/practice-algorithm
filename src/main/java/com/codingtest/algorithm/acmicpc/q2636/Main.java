package com.codingtest.algorithm.acmicpc.q2636;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 *  소요시간 : 116 ms
 *  메모리사용량 : 14284 KB
 */
public class Main {
    static int[][] board;
    static int prev;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int X, Y, remain;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        board = new int[X][Y];
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < Y; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) remain++;
            }
        }
        int cnt = 0;
        while (bfs(0, 0)) cnt++;
        System.out.println(cnt);
        System.out.println(prev);
    }

    private static boolean bfs(int x, int y) {
        boolean[][] visit = new boolean[X][Y];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        int removeCnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if (isInvalidRange(nextX, nextY) || visit[nextX][nextY]) continue;
                visit[nextX][nextY] = true;
                if (board[nextX][nextY] == 0) queue.offer(new int[]{nextX, nextY});
                else {
                    board[nextX][nextY] = 0;
                    removeCnt++;
                }
            }
        }
        remain -= removeCnt;
        if (removeCnt > 0) {
            prev = removeCnt;
        }
        return removeCnt > 0;
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= X || y >= Y;
    }
}
