package com.codingtest.algorithm.acmicpc.q2151;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int n, sr, sc, fr, fc;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    fr = sr;
                    fc = sc;
                    sr = i;
                    sc = j;
                }
            }
        }

        System.out.println(bfs());
    }

    static class Node {
        int r, c, dir, cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }

    private static int bfs() {
        int[][][] dist = new int[n][n][4];
        boolean[][][] visit = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.offer(new Node(sr, sc, i, 0));
            dist[sr][sc][i] = 0;
        }

        int nextR, nextC;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int row = poll.r;
            int col = poll.c;
            int dir = poll.dir;
            int cost = poll.cost;
            visit[row][col][dir] = true;

            nextR = row + dr[dir];
            nextC = col + dc[dir];
            if (isValid(nextR, nextC) && dist[nextR][nextC][dir] > cost) {
                dist[nextR][nextC][dir] = cost;
                queue.offer(new Node(nextR, nextC, dir, cost));
            }

            if (board[row][col] != '!') continue;
            for (int delta = 0; delta < 2; delta++) {
                int nextDir = (dir + delta * 2 + 1) % 4;
                nextR = row + dr[nextDir];
                nextC = col + dc[nextDir];
                if (isValid(nextR, nextC) && dist[nextR][nextC][nextDir] > cost + 1) {
                    dist[nextR][nextC][nextDir] = cost + 1;
                    queue.offer(new Node(nextR, nextC, nextDir, cost + 1));
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if(!visit[fr][fc][i]) continue;
            ret = Math.min(ret, dist[fr][fc][i]);
        }
        return ret;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n && board[r][c] != '*';
    }
}