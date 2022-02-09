package com.codingtest.algorithm.acmicpc.q2563;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[100][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    board[j][k] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j]) ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
