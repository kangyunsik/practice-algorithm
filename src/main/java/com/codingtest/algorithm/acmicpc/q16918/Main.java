package com.codingtest.algorithm.acmicpc.q16918;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final int INIT_BOOM_COUNT = 3;
    public static final int BLANK = -1;
    static int[][] board;
    static int R, C;
    static final int[] dr = {0, 0, 1, -1, 0};
    static final int[] dc = {1, -1, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (input[j] == 'O') {
                    board[i][j] = INIT_BOOM_COUNT;
                }else{
                    board[i][j] = BLANK;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            decreaseOneBoard();
            if (i % 2 == 0) {
                setBoardAllBoom();
            }
            boomAll();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] != BLANK) bw.append("O");
                else bw.append(".");
            }
            bw.newLine();
        }

        bw.flush();
    }

    private static void decreaseOneBoard() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] != BLANK) board[i][j]--;
            }
        }
    }

    private static void boomAll() {
        List<int[]> boomPos = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 0){
                    boomPos.add(new int[]{i, j});
                }
            }
        }

        for (int[] pos : boomPos) {
            for (int i = 0; i < dr.length; i++) {
                int nextR = pos[0] + dr[i];
                int nextC = pos[1] + dc[i];
                if(isValidRange(nextR, nextC)){
                    board[nextR][nextC] = -1;
                }
            }
        }
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void setBoardAllBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == BLANK){
                    board[i][j] = INIT_BOOM_COUNT;
                }
            }
        }
    }
}
