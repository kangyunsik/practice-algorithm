package com.codingtest.algorithm.acmicpc.q3109;

import java.io.*;
import java.util.StringTokenizer;

/***
 *  소요시간 : 340 ms
 *  메모리사용량 : 46,824 KB
 */
public class Main {
    static char[][] board;
    static final int[] dx = {-1, 0, 1};
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean dfs(int cur, int loc) {
        if (loc == m - 1) {
            cnt++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            board[cur][loc] = 'x';
            if (isValidRange(cur + dx[i]) && board[cur + dx[i]][loc + 1] == '.' &&
                    dfs(cur + dx[i], loc + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidRange(int x) {
        return x >= 0 && x < n;
    }
}
