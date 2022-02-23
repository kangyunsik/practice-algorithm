package com.codingtest.algorithm.acmicpc.q16236;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 *  소요시간 : 88 ms
 *  메모리사용량 : 12,244 KB
 */
public class Main {
    static int n;
    static int[][] board;
    static int babyX, babyY, eatCount;
    static int size = 2;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; st.hasMoreTokens(); j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    board[i][j] = 0;
                    babyX = i;
                    babyY = j;
                }
            }
        }
        bw.write(String.valueOf(simulate()));
        bw.flush();
    }

    private static int simulate() {
        PriorityQueue<Index> queue = new PriorityQueue<>();
        queue.add(new Index(babyX, babyY, 0));
        boolean[][] check = new boolean[n][n];
        int ret = 0;
        while (!queue.isEmpty()) {
            Index index = queue.poll();
            int curX = index.x;
            int curY = index.y;
            if (check[curX][curY] || board[curX][curY] > size) continue;
            check[curX][curY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (!isValidRange(nextX, nextY) || check[nextX][nextY]) continue;
                queue.add(new Index(nextX, nextY, index.move + 1));
            }

            if (board[curX][curY] > 0 && board[curX][curY] < size) {
                board[curX][curY] = 0;
                if (++eatCount == size) {
                    size++;
                    eatCount = 0;
                }
                queue.clear();
                queue.add(new Index(curX, curY, index.move));
                check = new boolean[n][n];
                ret = index.move;
            }
        }
        return ret;
    }

    private static boolean isValidRange(int nextX, int nextY) {
        return nextX >= 0 && nextX < n && nextY >= 0 && nextY < n;
    }

    static class Index implements Comparable<Index> {
        int x;
        int y;
        int move;

        @Override
        public int compareTo(Index o) {
            return this.move != o.move ? this.move - o.move
                    : (o.x != this.x ? this.x - o.x : this.y - o.y);
        }

        public Index(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
