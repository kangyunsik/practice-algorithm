package com.codingtest.algorithm.acmicpc.q4179;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int n, m, sr, sc;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static Queue<int[]> queue;
    static final char FIRE = 'F';
    static final char JI = 'J';

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        board = new char[n][];
        queue.offer(new int[]{-1, -1, JI});
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == JI) {
                    sr = i;
                    sc = j;
                } else if (board[i][j] == FIRE) {
                    queue.offer(new int[]{i, j, FIRE});
                }
            }
        }
        queue.peek()[0] = sr;
        queue.peek()[1] = sc;
        int ans = bfs();
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    private static int bfs() {
        int remain = 1;
        int depth = 0;
        while (remain > 0 && !queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];
                int type = poll[2];
                for (int dir = 0; dir < 4; dir++) {
                    int nr = row + dr[dir];
                    int nc = col + dc[dir];
                    if (type == JI) {
                        if (isOutOfRange(nr, nc)) {
                            if (board[row][col] == JI) return depth;
                            else continue;
                        }
                        if (board[nr][nc] != '.') continue;
                        remain++;
                        queue.offer(new int[]{nr, nc, type});
                    } else {
                        if (isOutOfRange(nr, nc) || board[nr][nc] == '#' || board[nr][nc] == FIRE) continue;
                        if (board[nr][nc] == JI) {
                            remain--;
                        }
                        queue.offer(new int[]{nr, nc, type});
                    }
                    board[nr][nc] = (char) type;
                }
            }

        }
        return -1;
    }

    private static boolean isOutOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}