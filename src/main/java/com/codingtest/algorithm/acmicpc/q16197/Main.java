package com.codingtest.algorithm.acmicpc.q16197;

import java.io.*;
import java.util.*;

public class Main {

    static class Status {
        int fr, fc, sr, sc;

        public Status(int fr, int fc, int sr, int sc) {
            this.fr = fr;
            this.fc = fc;
            this.sr = sr;
            this.sc = sc;
        }

        public Status move(int dir) {
            int nfr = this.fr + dr[dir];
            int nfc = this.fc + dc[dir];
            int nsr = this.sr + dr[dir];
            int nsc = this.sc + dc[dir];
            int blockCnt = 0;
            if (!outOfBoundPosition(nfr, nfc) && initBoard[nfr][nfc] == WALL) {
                nfr -= dr[dir];
                nfc -= dc[dir];
                blockCnt++;
            }

            if (!outOfBoundPosition(nsr, nsc) && initBoard[nsr][nsc] == WALL) {
                nsr -= dr[dir];
                nsc -= dc[dir];
                blockCnt++;
            }
            if (blockCnt == 2) return null;

            return new Status(nfr, nfc, nsr, nsc);
        }
    }

    static final char COIN = 'o';
    static final char EMPTY = '.';
    static final char WALL = '#';
    static char[][] initBoard;
    static int fr, fc, sr, sc;
    static int n, m;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initBoard = new char[n][];
        for (int i = 0; i < n; i++) {
            initBoard[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (initBoard[i][j] == COIN) {
                    sr = fr;
                    sc = fc;
                    fr = i;
                    fc = j;
                    initBoard[i][j] = EMPTY;
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(fr, fc, sr, sc));
        int depth = 0;
        while (!queue.isEmpty() && depth < 10) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Status poll = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    Status next;
                    if ((next = poll.move(dir)) != null) {
                        int outCnt = outOfBoundStatusCnt(next);
                        if (outCnt == 2) {
                            continue;
                        } else if (outCnt == 1) {
                            return depth;
                        }
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private static int outOfBoundStatusCnt(Status status) {
        int ret = 0;
        if (outOfBoundPosition(status.fr, status.fc)) ret++;
        if (outOfBoundPosition(status.sr, status.sc)) ret++;
        return ret;
    }

    private static boolean outOfBoundPosition(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}