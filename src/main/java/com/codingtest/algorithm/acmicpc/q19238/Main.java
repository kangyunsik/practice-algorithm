package com.codingtest.algorithm.acmicpc.q19238;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, gas, cnt, sr, sc;
    static int[][] custom;
    static int[][] board;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;

        custom = new int[m + 1][4];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                custom[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
            board[custom[i][0]][custom[i][1]] = -i;
        }

        while (cnt != m) {
            if (simulate()) cnt++;
            else break;
        }
        System.out.println(cnt == m ? gas : -1);
    }

    private static boolean simulate() {
        int[] idxDist = peekValidIdxAndDist();
        if (idxDist == null) return false;

        int idx = idxDist[0];
        int dist = idxDist[1];
        board[custom[idx][0]][custom[idx][1]] = 0;

        int nDist = getDestDist(idx);
        if (nDist == -1) return false;

        gas -= dist + nDist;
        if (gas < 0) return false;
        gas += nDist * 2;
        sr = custom[idx][2];
        sc = custom[idx][3];
        return true;
    }

    private static int[] peekValidIdxAndDist() {
        boolean[][] visit = new boolean[n][n];
        visit[sr][sc] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Queue<int[]> nextQueue = new LinkedList<>();
        pq.offer(new int[]{sr, sc});
        int depth = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] cur = pq.poll();
                int curR = cur[0];
                int curC = cur[1];
                if (board[curR][curC] < 0) {
                    return new int[]{-board[curR][curC], depth};
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = curR + dr[dir];
                    int nextC = curC + dc[dir];
                    if (isOutOfRange(nextR, nextC) || board[nextR][nextC] == 1 || visit[nextR][nextC]) continue;
                    visit[nextR][nextC] = true;
                    nextQueue.offer(new int[]{nextR, nextC});
                }
            }

            while (!nextQueue.isEmpty()) {
                pq.offer(nextQueue.poll());
            }
            depth++;
        }
        return null;
    }

    private static int getDestDist(int idx) {
        int destR = custom[idx][2];
        int destC = custom[idx][3];
        int depth = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        queue.offer(new int[]{custom[idx][0], custom[idx][1]});
        visit[custom[idx][0]][custom[idx][1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int curR = poll[0];
                int curC = poll[1];
                if (curR == destR && curC == destC) return depth;
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = curR + dr[dir];
                    int nextC = curC + dc[dir];
                    if (isOutOfRange(nextR, nextC) || board[nextR][nextC] == 1 || visit[nextR][nextC])
                        continue;
                    visit[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
            depth++;
        }
        return -1;
    }

    private static boolean isOutOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}