package com.codingtest.algorithm.acmicpc.q17142;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] seq;
    static List<int[]> virus;
    static int n, m, zero, ans = Integer.MAX_VALUE;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virus = new ArrayList<>();
        board = new int[n][n];
        seq = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virus.add(new int[]{i, j});
                } else if (board[i][j] == 0) {
                    zero++;
                }
            }
        }

        if(zero != 0)
            findCases(0, 0);
        else
            ans = 0;
        if (ans == Integer.MAX_VALUE)
            bw.write("-1\n");
        else
            bw.write(ans + "\n");
        bw.flush();
    }

    private static void findCases(int cnt, int cur) {
        if (cnt == m) {
            bfs();
            return;
        }

        for (int i = cur; i < virus.size(); i++) {
            seq[cnt] = i;
            findCases(cnt + 1, i + 1);
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i : seq) {
            queue.offer(new int[]{virus.get(i)[0], virus.get(i)[1], 0});
        }
        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) {
            temp[i] = Arrays.copyOf(board[i], board[i].length);
        }
        int remain = zero, ret = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (temp[poll[0]][poll[1]] == -1) continue;
            if (temp[poll[0]][poll[1]] == 0 && --remain == 0) {
                ret = poll[2];
                break;
            }
            temp[poll[0]][poll[1]] = -1;
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (inRange(nx, ny) && temp[nx][ny] != 1) {
                    queue.offer(new int[]{nx, ny, poll[2] + 1});
                }
            }
        }
        ans = Math.min(ans, ret);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
