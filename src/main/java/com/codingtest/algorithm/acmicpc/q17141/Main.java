package com.codingtest.algorithm.acmicpc.q17141;

import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> virus;
    static int n, m, zeroCnt, ans;
    static int[] selected;
    static int[][] board;

    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        board = new int[n][n];
        ans = Integer.MAX_VALUE;

        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                    virus.add(new int[]{i, j});
                }
                if (board[i][j] != 1) {
                    zeroCnt++;
                }
            }
        }
        findCases(0, 0);
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    private static void findCases(int cur, int sel) {
        if (sel == m) {
            ans = Math.min(ans, simulate());
            return;
        } else if (cur == virus.size()) {
            return;
        }
        selected[sel] = cur;
        findCases(cur + 1, sel + 1);
        findCases(cur + 1, sel);
    }

    private static int simulate() {
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int idx : selected) {
            int vr = virus.get(idx)[0];
            int vc = virus.get(idx)[1];
            queue.offer(new int[]{vr, vc});
            visit[vr][vc] = true;
        }

        int depth = -1;
        int remain = zeroCnt;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                remain--;
                int[] poll = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nr = poll[0] + dr[dir];
                    int nc = poll[1] + dc[dir];
                    if (isInvalidRange(nr, nc) || board[nr][nc] != 0 || visit[nr][nc]) {
                        continue;
                    }
                    visit[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return remain == 0 ? depth : Integer.MAX_VALUE;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}