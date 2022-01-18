package com.codingtest.algorithm.acmicpc.q14503;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean mustBack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        int x, y, d;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = 1;
        board[x][y] = -1;
        while (isContinuable(x, y, getBack(d))) {
            if (mustBack) {
                x += dx[getBack(d)];
                y += dy[getBack(d)];
                mustBack = false;
            } else if (leftClearable(x, y, getLeft(d))) {
                d = getLeft(d);
                x += dx[d];
                y += dy[d];
                ans++;
                board[x][y] = -1;
            } else {
                d = getLeft(d);
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }

    private static boolean leftClearable(int x, int y, int left) {
        return board[x+dx[left]][y+dy[left]] == 0;
    }

    private static int getLeft(int d) {
        return (d + 3) % 4;
    }

    private static int getBack(int d) {
        return (d + 2) % 4;
    }

    private static boolean isContinuable(int x, int y, int back) {
        for (int i = 0; i < 4; i++) {
            if (board[x + dx[i]][y + dy[i]] == 0) {
                return true;
            }
        }
        mustBack = true;
        return board[x + dx[back]][y + dy[back]] != 1;
    }
}
