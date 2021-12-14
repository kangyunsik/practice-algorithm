package com.codingtest.algorithm.acmicpc.q14939;

import java.io.*;

public class Main {
    static char[][] board;
    static final int[] dx = {0, 0, 0, 1, -1};
    static final int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.MAX_VALUE;
        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 1 << 10; i++) {
            int p = progress(copyOf(board), i);
            answer = Math.min(answer, p);
        }
        if (answer == Integer.MAX_VALUE)
            answer = -1;
        bw.write(answer + "\n");
        bw.flush();
    }

    private static int progress(char[][] temp, int i) {
        int cnt = 0;

        for (int h = 0; h < 10 && i > 0; h++, i/=2) {
            if (i % 2 == 1){
                cnt++;
                turn(temp, 0, h);
            }
        }

        for (int j = 1; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (temp[j - 1][k] == 'O') {
                    cnt++;
                    turn(temp, j, k);
                }
            }
        }

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (temp[j][k] == 'O') {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 10 && y < 10;
    }

    private static void turn(char[][] temp, int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (inRange(x + dx[i], y + dy[i])) {
                temp[x + dx[i]][y + dy[i]] = temp[x + dx[i]][y + dy[i]] == '#' ? 'O' : '#';
            }
        }
    }

    private static char[][] copyOf(char[][] board) {
        char[][] temp = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }
}