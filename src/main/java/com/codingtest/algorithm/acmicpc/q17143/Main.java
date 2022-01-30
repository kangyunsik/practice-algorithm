package com.codingtest.algorithm.acmicpc.q17143;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Shark[][] board;
    static int catchCnt;
    static int r, c;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new Shark[r][c];
        int R, C, S, D, Z;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken()) - 1;
            C = Integer.parseInt(st.nextToken()) - 1;
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken()) - 1;
            Z = Integer.parseInt(st.nextToken());
            board[R][C] = new Shark(R, C, S, D, Z);
        }

        for (int kingLocation = 0; kingLocation < c; kingLocation++) {
            catchShark(kingLocation);
            moveShark();
        }
        bw.write(catchCnt + "\n");
        bw.flush();
    }

    private static void catchShark(int location) {
        for (int i = 0; i < r; i++) {
            if (board[i][location] != null) {
                catchCnt += board[i][location].size;
                board[i][location] = null;
                break;
            }
        }
    }

    private static void moveShark() {
        List<Shark> temp = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != null) {
                    board[i][j].move();
                    temp.add(board[i][j]);
                    board[i][j] = null;
                }
            }
        }

        for (Shark shark : temp) {
            Shark prev = board[shark.x][shark.y];
            if (prev == null) {
                board[shark.x][shark.y] = shark;
            } else {
                if (prev.size < shark.size) {
                    board[shark.x][shark.y] = shark;
                } else {
                    board[shark.x][shark.y] = prev;
                }
            }
        }
    }

    static class Shark {
        int x;
        int y;
        int velocity;
        int direction;
        int size;

        public Shark(int x, int y, int velocity, int direction, int size) {
            this.x = x;
            this.y = y;
            this.velocity = velocity % ((direction < 2 ? r - 1 : c - 1) * 2);
            this.direction = direction;
            this.size = size;
        }

        public void move() {
            x += dx[direction] * velocity;
            y += dy[direction] * velocity;
            while (outOfRange(x, y)) {
                if (x >= r) x = 2 * (r - 1) - x;
                else if (x < 0) x *= -1;
                else if (y >= c) y = 2 * (c - 1) - y;
                else if (y < 0) y *= -1;
                reverseDirection();
            }
        }

        private void reverseDirection() {
            if(direction < 2) direction = 1 - direction;
            else direction = 5 - direction;
        }

        private boolean outOfRange(int x, int y) {
            return x >= r || x < 0 || y >= c || y < 0;
        }
    }
}
