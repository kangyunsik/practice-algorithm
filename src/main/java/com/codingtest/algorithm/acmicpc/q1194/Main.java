package com.codingtest.algorithm.acmicpc.q1194;

import java.io.*;
import java.util.*;

/***
 *  120 ms
 *  14880 KB
 */
public class Main {
    static char[][] board;
    static int n, m;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][];
        int[] loc = null;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            if (loc != null) continue;
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '0') {
                    loc = new int[]{i, j};
                    board[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(loc[0], loc[1]));
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][1 << 6];
        queue.offer(new int[]{r, c, 0, 0});
        visit[r][c][0] = true;
        int st, dist, nr, nc;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            r = poll[0];
            c = poll[1];
            st = poll[2];
            dist = poll[3];
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                if (isInvalidRange(nr, nc) || visit[nr][nc][st]) continue;
                char nextCh = board[nr][nc];
                if (Character.isLowerCase(nextCh)) {
                    int nst = st | 1 << (nextCh - 'a');
                    if (visit[nr][nc][nst]) continue;
                    visit[nr][nc][nst] = true;
                    queue.offer(new int[]{nr, nc, nst, dist + 1});
                } else if (Character.isUpperCase(nextCh) && (st & 1 << nextCh - 'A') > 0) {
                    visit[nr][nc][st] = true;
                    queue.offer(new int[]{nr, nc, st, dist + 1});
                } else if (nextCh == '.') {
                    visit[nr][nc][st] = true;
                    queue.offer(new int[]{nr, nc, st, dist + 1});
                } else if (nextCh == '1') {
                    return dist + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
