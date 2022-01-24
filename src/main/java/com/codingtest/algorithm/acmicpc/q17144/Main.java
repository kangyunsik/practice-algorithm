package com.codingtest.algorithm.acmicpc.q17144;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] board;
    static int r, c;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int a1, a2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        board = new int[r][];
        for (int i = 0; i < r; i++) {
            board[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (board[i][0] == -1) {
                a2 = i;
                a1 = i - 1;
            }
        }
        while (t-- > 0) {
            diffusion();
            upperActivate();
            lowerActivate();
        }
        int ans = getSum();
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void lowerActivate() {
        for (int i = a2+1; i < r-1; i++) {
            board[i][0] = board[i+1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            board[r-1][i] = board[r-1][i+1];
        }
        for (int i = r-1; i > a2; i--) {
            board[i][c-1] = board[i-1][c-1];
        }
        for (int i = c-1; i > 1 ; i--) {
            board[a2][i] = board[a2][i-1];
        }
        board[a2][1] = 0;
    }


    private static void upperActivate() {
        for (int i = a1 - 1; i > 0 ; i--) {
            board[i][0] = board[i-1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            board[0][i] = board[0][i+1];
        }
        for (int i = 0; i < a1; i++) {
            board[i][c-1] = board[i+1][c-1];
        }
        for (int i = c-1; i > 1 ; i--) {
            board[a1][i] = board[a1][i-1];
        }
        board[a1][1] = 0;
    }

    private static void diffusion() {
        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];
                    if (inRange(px, py) && board[px][py] != -1 && board[i][j] >= 5) {
                        queue.offer(new Info(px,py,board[i][j]/5));
                        cnt++;
                    }
                }
                board[i][j] -= board[i][j] / 5 * cnt;
            }
        }

        while(!queue.isEmpty()){
            Info poll = queue.poll();
            board[poll.x][poll.y] += poll.value;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != -1) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }

    static class Info{
        int x;
        int y;
        int value;

        public Info(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
