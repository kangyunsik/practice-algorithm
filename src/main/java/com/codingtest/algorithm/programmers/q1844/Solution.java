package com.codingtest.algorithm.programmers.q1844;

import java.util.*;

class Solution {

    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        Queue<Index> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];

        queue.offer(new Index(0, 0, 1));
        while (!queue.isEmpty()) {
            Index p = queue.poll();
            if (visit[p.x][p.y]) continue;
            visit[p.x][p.y] = true;
            if (p.x == n - 1 && p.y == m - 1) {
                return p.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    queue.offer(new Index(nx, ny, p.cost + 1));
                }
            }
        }
        return -1;
    }
}

class Index {
    int x;
    int y;
    int cost;

    public Index(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}