package com.codingtest.algorithm.acmicpc.q1987;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[] already = new boolean[26];
    static int answer, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] temp;
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            temp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[i][j] = temp[j] - 'A';
            }
        }
        find(0, 0, 1);
        System.out.println(answer);
    }

    private static void find(int i, int j, int depth) {
        already[board[i][j]] = true;
        answer = Math.max(depth, answer);
        for (int k = 0; k < 4; k++) {
            int px = i + dx[k];
            int py = j + dy[k];
            if (inRange(px, py) && !already[board[px][py]]) {
                find(px, py, depth + 1);
            }
        }
        already[board[i][j]] = false;
    }

    private static boolean inRange(int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
