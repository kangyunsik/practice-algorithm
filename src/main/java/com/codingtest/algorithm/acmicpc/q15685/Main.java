package com.codingtest.algorithm.acmicpc.q15685;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board = new boolean[101][101];
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            new Dragon(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))
                    .draw();
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]){
                    ans++;
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    static class Dragon {
        int sx, ex;
        int sy, ey;
        int gen;
        int dir;
        List<Integer> mi = new ArrayList<>();

        public Dragon(int sx, int sy, int dir, int gen) {
            this.sx = sx;
            this.sy = sy;
            this.dir = dir;
            this.gen = gen;
            init(sx, sy, dir, gen);
        }

        private void init(int sx, int sy, int dir, int gen) {
            if (gen == 0) {
                mi.add(dir);
                this.ex = sx + dx[dir];
                this.ey = sy + dy[dir];
            } else {
                init(sx, sy, dir, gen - 1);
                mergeRotate();
            }
        }

        private void mergeRotate() {
            List<Integer> ti = new ArrayList<>();
            for (int i = mi.size() - 1; i >= 0; i--) {
                int nDir = (mi.get(i) + 1) % 4;
                ti.add(nDir);
                ex += dx[nDir];
                ey += dy[nDir];
            }
            mi.addAll(ti);
        }

        public void draw() {
            int x = sx;
            int y = sy;
            board[x][y] = true;
            for (Integer tDir : mi) {
                x += dx[tDir];
                y += dy[tDir];
                board[x][y] = true;
            }
        }
    }
}
