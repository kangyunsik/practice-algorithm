package com.codingtest.algorithm.acmicpc.q16234;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static boolean[][] right;
    static boolean[][] down;
    static int[][] board;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int ans = 0;
        while (compact(n, l, r)) ans++;
        bw.write(ans + "\n");
        bw.flush();
    }

    private static boolean compact(int n, int l, int r) {
        right = new boolean[n][n];
        down = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n) {
                    int diff = Math.abs(board[i][j] - board[i + 1][j]);
                    if (l <= diff && diff <= r) {
                        down[i][j] = true;
                    }
                }
                if (j + 1 < n) {
                    int diff = Math.abs(board[i][j] - board[i][j + 1]);
                    if (l <= diff && diff <= r) {
                        right[i][j] = true;
                    }
                }
            }
        }

        boolean flag = false;

        Queue<Pos> temp = new LinkedList<>();
        Queue<Pos> queue = new LinkedList<>();

        boolean[][] already = new boolean[n][n];
        int sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!already[i][j]) {
                    sum = 0;
                    already[i][j] = true;
                    queue.offer(new Pos(i, j));
                    while (!queue.isEmpty()) {
                        Pos poll = queue.poll();
                        int X = poll.x;
                        int Y = poll.y;
                        sum += board[X][Y];
                        temp.offer(new Pos(X, Y));

                        for (int k = 0; k < 4; k++) {
                            int px = X + dx[k];
                            int py = Y + dy[k];
                            if (inRange(px, py, n) && !already[px][py]) {
                                int nx = px - dx[k] > 0 ? 1 : 0;
                                int ny = py - dy[k] > 0 ? 1 : 0;
                                if ((dx[k] == 0 && right[nx][ny]) || (dy[k] == 0 && down[nx][ny])) {
                                    already[px][py] = true;
                                    queue.offer(new Pos(px, py));
                                }
                            }
                        }
                    }

                    int size = temp.size();
                    while (!temp.isEmpty()) {
                        Pos poll = temp.poll();
                        board[poll.x][poll.y] = sum / size;
                    }
                    if (size != 1) {
                        flag = true;
                    }
                }

            }
        }
        return flag;
    }

    private static boolean inRange(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
