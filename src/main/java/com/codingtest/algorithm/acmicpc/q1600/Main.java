package com.codingtest.algorithm.acmicpc.q1600;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 *  소요시간 : 508 ms
 *  메모리사용량 : 88304 KB
 */
public class Main {
    static int[][] board;
    static boolean[][][] already;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};
    static final int[] jr = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] jc = {2, 1, -1, -2, -2, -1, 1, 2};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        already = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, k});
        already[0][0][0] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            int cost = poll[2];
            int jump = poll[3];
            if (r == n - 1 && c == m - 1) {
                ans = cost;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isInvalidRange(nr, nc) || already[nr][nc][jump] || board[nr][nc] != 0) continue;
                already[nr][nc][jump] = true;
                queue.offer(new int[]{nr, nc, cost + 1, jump});
            }

            if (jump > 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + jr[i];
                    int nc = c + jc[i];
                    if (isInvalidRange(nr, nc) || already[nr][nc][jump - 1] || board[nr][nc] != 0) continue;
                    already[nr][nc][jump - 1] = true;
                    queue.offer(new int[]{nr, nc, cost + 1, jump - 1});
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
