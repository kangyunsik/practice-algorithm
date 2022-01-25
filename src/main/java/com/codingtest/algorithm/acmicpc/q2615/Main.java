package com.codingtest.algorithm.acmicpc.q2615;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int win ,ansX, ansY;
    static int[][] board;
    static final int[] dx = {-1, 0, 1, 1};
    static final int[] dy = {1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        board = new int[19][];

        for (int i = 0; i < 19; i++) {
            board[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[j][i] > 0 && win == 0)
                    find(j, i);
            }
        }

        bw.write(win + "\n");
        if(win > 0) bw.write((ansX+1) + " " + (ansY+1));
        bw.flush();
    }

    private static void find(int x, int y) {
        int color = board[x][y];
        for (int i = 0; i < 4; i++) {
            int px = x, py = y, cur = 0;

            while (inRange(px, py) && board[px][py] == color) {
                cur++;
                px += dx[i];
                py += dy[i];
            }

            if (cur == 5) {
                if (!inRange(x - dx[i], y - dy[i]) || board[x - dx[i]][y - dy[i]] != color) {
                    win = color;
                    ansX = x;
                    ansY = y;
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }
}
