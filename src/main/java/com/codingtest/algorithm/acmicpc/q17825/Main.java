package com.codingtest.algorithm.acmicpc.q17825;

import java.io.*;
import java.util.*;

public class Main {

    static int[] moveCnt;
    static int[] seq;
    static int ans, score;
    static int[][] board;
    static int[][] loc = new int[4][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        initBoard();
        moveCnt = new int[10];
        seq = new int[10];
        for (int i = 0; i < 10; i++) {
            moveCnt[i] = Integer.parseInt(st.nextToken());
        }
        findSeq(0);
        System.out.println(ans);
    }

    private static void initBoard() {
        board = new int[4][];
        board[0] = new int[21];
        for (int i = 1; i <= 20; i++) {
            board[0][i] = i * 2;
        }
        board[1] = new int[]{10, 13, 16, 19, 25, 30, 35, 40};
        board[2] = new int[]{20, 22, 24, 25, 30, 35, 40};
        board[3] = new int[]{30, 28, 27, 26, 25, 30, 35, 40};
    }

    private static void simulate() {
        for (int i = 0; i < 4; i++) {
            loc[i][0] = 0;
            loc[i][1] = 0;
        }
        for (int i = 0; i < 10; i++) {
            if (!move(i)) return;
        }
        ans = Math.max(ans, score);
    }

    private static boolean move(int idx) {
        int[] cur = loc[seq[idx]];
        if (cur[1] == -1) return false;
        int nextLoc = cur[0] + moveCnt[idx];

        if (nextLoc >= board[cur[1]].length) {
            cur[0] = -1;
            cur[1] = -1;
            return true;
        }

        cur[0] = nextLoc;
        if (cur[1] == 0 && nextLoc % 5 == 0 && nextLoc != 20) {
            cur[0] = 0;
            cur[1] = nextLoc / 5;
        }

        score += board[cur[1]][cur[0]];
        return !checkAlready(cur);
    }

    private static boolean checkAlready(int[] cur) {
        int cnt = 0;
        for (int[] other : loc) {
            if (other[1] == -1) continue;
            if (other[0] == cur[0] && other[1] == cur[1]) cnt++;
            else if (cur[1] != 0 && other[1] != 0 && board[cur[1]].length - cur[0] <= 3) {
                if (board[cur[1]].length - cur[0] == board[other[1]].length - other[0]) cnt++;
            } else if (cur[0] == board[cur[1]].length - 1 && other[0] == board[other[1]].length - 1) cnt++;
        }
        return cnt > 1;
    }

    private static void findSeq(int cur) {
        if (cur == 10) {
            score = 0;
            simulate();
            return;
        }

        for (int i = 0; i < 4; i++) {
            seq[cur] = i;
            findSeq(cur + 1);
        }
    }
}