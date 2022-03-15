package com.codingtest.algorithm.acmicpc.q1189;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0, R, C, K;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new String[R];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine();
        }
        dfs(R - 1, 0, 1 << (R - 1) * 5, 1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void dfs(int r, int c, int visit, int cost) {
        if (r == 0 && c == C - 1 && cost == K) {
            ans++;
            return;
        } else if (cost > K) return;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            int visitFlag = 1 << (nextR * 5 + nextC);
            if (!isValidRange(nextR, nextC) || (visit & visitFlag) > 0 || board[nextR].charAt(nextC) == 'T') continue;
            dfs(nextR, nextC, visit | visitFlag, cost + 1);
        }
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
