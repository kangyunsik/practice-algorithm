package com.codingtest.algorithm.acmicpc.q17244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n, m, rCnt = 0;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = (char) (rCnt++);
                } else if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(sx, sy));
    }

    private static int bfs(int sx, int sy) {
        boolean[][][] visit = new boolean[n][m][1 << rCnt];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0, 0}); // r, c, depth, visit
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            int dist = poll[2];
            int status = poll[3];
            if (visit[r][c][status]) continue;
            visit[r][c][status] = true;
            if(board[r][c] == 'E' && status == (1 << rCnt) - 1){
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isInvalidRange(nr, nc)) continue;
                char temp = board[nr][nc];
                if(temp == '.' || temp == 'E'){
                    queue.offer(new int[]{nr, nc, dist + 1, status});
                }else if(temp <= 5){
                    queue.offer(new int[]{nr, nc, dist + 1, status | 1 << temp});
                }
            }
        }
        return -1;
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
