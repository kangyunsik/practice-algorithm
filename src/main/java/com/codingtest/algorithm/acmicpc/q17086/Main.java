package com.codingtest.algorithm.acmicpc.q17086;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int n, m;
    static List<int[]> sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sharks = new ArrayList<>();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    sharks.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                for (int[] shark : sharks) {
                    tmp = Math.min(tmp, Math.max(Math.abs(i - shark[0]), Math.abs(j - shark[1])));
                }
                ans = Math.max(ans, tmp);
            }
        }
        System.out.println(ans);
    }
}