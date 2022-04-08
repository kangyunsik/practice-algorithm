package com.codingtest.algorithm.acmicpc.q14502;

import java.io.*;
import java.util.*;

/***
 *  소요시간: 328 ms
 *  메모리사용량: 121920 KB
 */
public class Main {
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int ADDITIONAL_WALL_CNT = 3;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int n, m, safeCnt = -ADDITIONAL_WALL_CNT, minPolutionCnt = Integer.MAX_VALUE;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == EMPTY) safeCnt++;
            }
        }
        findCases(0, 0);
        System.out.println(safeCnt - minPolutionCnt);
    }

    private static void findCases(int cur, int selectCnt) {
        if (selectCnt == ADDITIONAL_WALL_CNT) {
            minPolutionCnt = Math.min(minPolutionCnt, simulate());
            return;
        }
        if (cur == n * m) return;
        int row = cur / m;
        int col = cur % m;
        if (board[row][col] == 0) {
            board[row][col] = WALL;
            findCases(cur + 1, selectCnt + 1);
            board[row][col] = EMPTY;
        }
        findCases(cur + 1, selectCnt);
    }

    private static int simulate() {
        boolean[][] visit = new boolean[n][m];
        int pollutionCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != VIRUS) continue;
                pollutionCnt += bfs(i, j, visit);
                if (pollutionCnt >= minPolutionCnt) return minPolutionCnt;
            }
        }
        return pollutionCnt;
    }

    private static int bfs(int r, int c, boolean[][] visit) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll[0] + dr[dir];
                int nc = poll[1] + dc[dir];
                if (isInvalidRange(nr, nc) || visit[nr][nc] || board[nr][nc] != EMPTY) continue;
                visit[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
