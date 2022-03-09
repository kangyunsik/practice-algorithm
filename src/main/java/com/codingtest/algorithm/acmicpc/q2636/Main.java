package com.codingtest.algorithm.acmicpc.q2636;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int prev;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int X, Y, remain;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        board = new int[X][Y];
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < Y; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) remain++;
            }
        }

        int cnt = 0;
        while (bfs(0, 0)) {
            cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(String.valueOf(prev));
        bw.flush();
    }

    private static boolean bfs(int x, int y) {
        boolean[][] visit = new boolean[X][Y];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> removeList = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if (isValidRange(nextX, nextY) && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    if (board[nextX][nextY] == 0)
                        queue.offer(new int[]{nextX, nextY});
                    else
                        removeList.offer(new int[]{nextX, nextY});
                }
            }
        }

        if(removeList.size() == 0) return false;
        prev = remain;
        for (int[] pos : removeList) {
            board[pos[0]][pos[1]] = 0;
            remain--;
        }
        return true;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < X && y < Y;
    }
}
