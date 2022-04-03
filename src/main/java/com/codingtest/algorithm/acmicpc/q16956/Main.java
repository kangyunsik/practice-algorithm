package com.codingtest.algorithm.acmicpc.q16956;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n, m;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'S') continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (isInvalidRange(nr, nc)) continue;
                    if (board[nr][nc] == 'W') {
                        bw.write("0");
                        bw.flush();
                        return;
                    }else if(board[nr][nc] == '.'){
                        board[nr][nc] = 'D';
                    }
                }
            }
        }
        sb.append("1").append("\n");
        for (char[] t : board) {
            sb.append(t).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
