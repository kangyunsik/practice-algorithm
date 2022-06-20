package com.codingtest.algorithm.acmicpc.q1726;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c, dir, cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }

    static int n, m;
    static int[][] board;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int r, c, dir;
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        dir = dirConvert(Integer.parseInt(st.nextToken()) - 1);
        q.offer(new Node(r, c, dir, 0));

        int[][][] dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[r][c][dir] = 0;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        dir = dirConvert(Integer.parseInt(st.nextToken()) - 1);

        int curR, curC, curDir, nextR, nextC, nextDir;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            curR = cur.r;
            curC = cur.c;
            curDir = cur.dir;
            int cost = cur.cost + 1;

            for (int straight = 1; straight <= 3; straight++) {
                nextR = curR + dr[curDir] * straight;
                nextC = curC + dc[curDir] * straight;
                if (isInvalidRange(nextR, nextC) || dist[nextR][nextC][curDir] <= cost) continue;
                if (board[nextR][nextC] == 1) break;
                dist[nextR][nextC][curDir] = cost;
                q.offer(new Node(nextR, nextC, curDir, cost));
            }

            for (int delta = -1; delta <= 1; delta += 2) {
                nextDir = (curDir + delta + 4) % 4;
                if (dist[curR][curC][nextDir] <= cost) continue;
                dist[curR][curC][nextDir] = cost;
                q.offer(new Node(curR, curC, nextDir, cost));
            }
        }
        System.out.println(dist[r][c][dir]);
    }

    private static int dirConvert(int prevDir) {
        if (prevDir == 1) return 2;
        if (prevDir == 2) return 1;
        return prevDir;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}