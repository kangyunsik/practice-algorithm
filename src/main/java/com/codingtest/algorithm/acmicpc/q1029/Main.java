package com.codingtest.algorithm.acmicpc.q1029;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = input[j] - '0';
            }
        }

        int ans = 0;
        int[][][] dist = new int[n][10][1 << n];// cur, cost, status
        dist[0][0][1] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1, 1}); // cur, cost, status, depth
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int cost = poll[1];
            int status = poll[2];
            int depth = poll[3];
            ans = Math.max(ans, depth);
            for (int i = 1; i < n; i++) {
                if ((status & 1 << i) > 0 || board[cur][i] < cost) continue;
                int nextStatus = status | 1 << i;
                if (dist[i][board[cur][i]][nextStatus] >= depth) continue;
                dist[i][board[cur][i]][nextStatus] = depth + 1;
                queue.offer(new int[]{i, board[cur][i], nextStatus, depth + 1});
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
