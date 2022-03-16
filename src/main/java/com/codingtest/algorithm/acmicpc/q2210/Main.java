package com.codingtest.algorithm.acmicpc.q2210;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[][] board = new char[5][5];
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static char[] seq = new char[6];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0);
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static void dfs(int r, int c, int depth) {
        if (depth == 6) {
            set.add(new String(seq));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (!isValidRange(nextR, nextC)) continue;
            seq[depth] = board[nextR][nextC];
            dfs(nextR, nextC, depth + 1);
        }
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < 5 && c < 5;
    }
}
