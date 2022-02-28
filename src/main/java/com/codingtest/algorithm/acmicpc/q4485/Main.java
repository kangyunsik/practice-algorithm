package com.codingtest.algorithm.acmicpc.q4485;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int test_case = 1, ans;
        while (n != 0) {
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = dijkstra();
            bw.append("Problem ").append(String.valueOf(test_case)).append(": ").append(String.valueOf(ans));
            bw.newLine();
            n = Integer.parseInt(br.readLine());
            test_case++;
        }
        bw.flush();
    }

    private static int dijkstra() {
        int[][] dist = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = board[0][0];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        queue.offer(new int[]{0, 0, board[0][0]});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int cost = pos[2];
            if (visit[x][y]) continue;
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (isInvalidRange(nextX, nextY) || visit[nextX][nextY]) continue;
                int nextCost = board[nextX][nextY] + cost;
                if (nextCost > dist[nextX][nextY]) continue;
                dist[nextX][nextY] = nextCost;
                queue.offer(new int[]{nextX, nextY, nextCost});
            }
        }
        return dist[n - 1][n - 1];
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}