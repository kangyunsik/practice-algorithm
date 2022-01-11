package com.codingtest.algorithm.acmicpc.q14442;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dist;
    static boolean[][][] check;
    static String[] map;
    static int n, m, k;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new String[n];
        dist = new int[n][m][k + 1];
        check = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        bfs(0, 0);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (dist[n - 1][m - 1][i] != -1) {
                ans = Math.min(ans, dist[n - 1][m - 1][i]);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void bfs(int x, int y) {
        int dep, cost;
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x, y, 0, 1));

        while (!queue.isEmpty()) {
            Index poll = queue.poll();
            x = poll.x;
            y = poll.y;
            dep = poll.dep;
            cost = poll.cost;
            dist[x][y][dep] = cost;

            for (int i = 0; i < 4; i++) {
                int px = dx[i] + x;
                int py = dy[i] + y;
                if (inRange(px, py)) {
                    if (map[px].charAt(py) == '0' && !check[px][py][dep]) {
                        check[px][py][dep] = true;
                        queue.offer(new Index(px, py, dep, cost + 1));
                    } else if (map[px].charAt(py) == '1' && dep + 1 <= k && !check[px][py][dep + 1]) {
                        check[px][py][dep + 1] = true;
                        queue.offer(new Index(px, py, dep + 1, cost + 1));
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}

class Index {
    int x;
    int y;
    int dep;
    int cost;

    public Index(int x, int y, int dep, int cost) {
        this.x = x;
        this.y = y;
        this.dep = dep;
        this.cost = cost;
    }
}
