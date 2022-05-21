package com.codingtest.algorithm.acmicpc.q2665;

import java.io.*;
import java.util.*;

public class Main {

    static class Status implements Comparable<Status>{

        int r, c, cost;

        public Status(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Status o) {
            return cost - o.cost;
        }
    }

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {-1, 1, 0, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.offer(new Status(0, 0, 0));
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            Status status = pq.poll();
            int curR = status.r;
            int curC = status.c;
            int curCost = status.cost;
            for (int dir = 0; dir < 4; dir++) {
                int nr = curR + dr[dir];
                int nc = curC + dc[dir];
                if (isInvalidRange(nr, nc)) {
                    continue;
                }
                int nextCost = curCost + (board[nr][nc] == '0' ? 1 : 0);
                if (cost[nr][nc] <= nextCost) {
                    continue;
                }
                cost[nr][nc] = nextCost;
                pq.offer(new Status(nr, nc, nextCost));
            }
        }
        System.out.println(cost[n - 1][n - 1]);
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}