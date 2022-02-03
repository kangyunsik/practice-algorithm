package com.codingtest.algorithm.acmicpc.q1600;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] board;
    static boolean[][][] already;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static final int[] jx = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] jy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][];
        already = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, k});
        already[0][0][0] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == n - 1 && poll[1] == m - 1) {
                ans = poll[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int px = poll[0] + dx[i];
                int py = poll[1] + dy[i];
                if (inRange(px, py) && !already[px][py][poll[3]] && board[px][py] == 0) {
                    already[px][py][poll[3]] = true;
                    queue.offer(new int[]{px, py, poll[2] + 1, poll[3]});
                }
            }

            if (poll[3] > 0) {
                for (int i = 0; i < 8; i++) {
                    int px = poll[0] + jx[i];
                    int py = poll[1] + jy[i];
                    if (inRange(px, py) && !already[px][py][poll[3] - 1] && board[px][py] == 0) {
                        already[px][py][poll[3] - 1] = true;
                        queue.offer(new int[]{px, py, poll[2] + 1, poll[3] - 1});
                    }
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
