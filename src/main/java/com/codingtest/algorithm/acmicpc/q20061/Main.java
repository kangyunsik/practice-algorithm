package com.codingtest.algorithm.acmicpc.q20061;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] green, blue;
    static int score;
    static final int ROW = 6;
    static final int COL = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        green = new boolean[ROW][COL];
        blue = new boolean[ROW][COL];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int shape = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            simulate(green, shape, y);
            if (shape == 1) simulate(blue, shape, x);
            else simulate(blue, 5 - shape, x);
        }

        int all = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (green[i][j]) all++;
                if (blue[i][j]) all++;
            }
        }

        System.out.println(score);
        System.out.println(all);
    }

    private static void simulate(boolean[][] board, int type, int c) {
        put(board, type, c);
        List<Integer> clearedLine = lineClear(board);
        compactDown(board, clearedLine);
        remainPush(board);
    }

    private static void put(boolean[][] board, int type, int c) {
        if (type == 1) {
            putOneOne(board, c);
        } else if (type == 2) {
            putOneTwo(board, c);
        } else {
            putTwoOne(board, c);
        }
    }

    private static void putOneOne(boolean[][] board, int c) {
        int i;
        for (i = 0; i < ROW; i++) {
            if (board[i][c]) break;
        }
        board[i - 1][c] = true;
    }

    private static void putOneTwo(boolean[][] board, int c) {
        int i;
        for (i = 0; i < ROW; i++) {
            if (board[i][c] || board[i][c + 1]) break;
        }
        board[i - 1][c] = board[i - 1][c + 1] = true;
    }

    private static void putTwoOne(boolean[][] board, int c) {
        int i;
        for (i = 0; i < ROW; i++) {
            if (board[i][c]) break;
        }
        board[i - 1][c] = board[i - 2][c] = true;
    }


    private static List<Integer> lineClear(boolean[][] board) {
        List<Integer> ret = new ArrayList<>();
        lb:
        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = 0; j < COL; j++) {
                if(!board[i][j]) continue lb;
            }
            for (int j = 0; j < COL; j++) {
                board[i][j] = false;
            }
            score++;
            ret.add(i);
        }
        return ret;
    }

    private static void compactDown(boolean[][] board, List<Integer> clearedLine) {
        int pass = 0;
        for (int i = ROW - 1; i >= clearedLine.size() ; i--) {
            if(pass != 2 && clearedLine.contains(i)) {
                pass++;
                if(clearedLine.contains(i - 1)) pass++;
            }
            for (int j = 0; j < COL; j++) {
                board[i][j] = board[i - pass][j];
            }
        }


        for (int i = 0; i < clearedLine.size(); i++) {
            Arrays.fill(board[i], false);
        }
    }

    private static void remainPush(boolean[][] board) {
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < COL; j++) {
                if(board[i][j]){
                    cnt++;
                    break;
                }
            }
        }
        for (int i = ROW - 1; i >= 2; i--) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = board[i - cnt][j];
            }
        }
        Arrays.fill(board[0], false);
        Arrays.fill(board[1], false);
    }
}