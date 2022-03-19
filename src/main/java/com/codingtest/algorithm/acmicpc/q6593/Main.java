package com.codingtest.algorithm.acmicpc.q6593;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][][] board = new char[31][31][];
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};
    static int H, R, C, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        while (!(H == 0 && R == 0 && C == 0)) {
            ans = Integer.MAX_VALUE;
            int sh, sr, sc;
            sh = sr = sc = -1;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < R; j++) {
                    board[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (board[i][j][k] == 'S') {
                            sh = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
                br.readLine();
            }
            bfs(sh, sr, sc);
            if (ans == Integer.MAX_VALUE) bw.write("Trapped!\n");
            else bw.write(String.format("Escaped in %d minute(s).\n", ans));

            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
        bw.flush();
    }

    static class Index {
        int h, r, c;

        public Index(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(int sh, int sr, int sc) {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(sh, sr, sc));
        int[][][] dist = new int[H][R][C];
        boolean[][][] visit = new boolean[H][R][C];
        visit[sh][sr][sc] = true;
        Index p;
        int nextH, nextR, nextC;
        while (!queue.isEmpty()) {
            p = queue.poll();
            for (int i = 0; i < 6; i++) {
                nextH = p.h + dh[i];
                nextR = p.r + dr[i];
                nextC = p.c + dc[i];
                if (!isValidRange(nextH, nextR, nextC) || board[nextH][nextR][nextC] == '#') continue;
                if (visit[nextH][nextR][nextC]) continue;
                visit[nextH][nextR][nextC] = true;
                dist[nextH][nextR][nextC] = dist[p.h][p.r][p.c] + 1;
                if (board[nextH][nextR][nextC] == 'E') {
                    ans = dist[nextH][nextR][nextC];
                    return;
                }
                queue.offer(new Index(nextH, nextR, nextC));
            }
        }
    }

    private static boolean isValidRange(int h, int r, int c) {
        return h >= 0 && h < H && r >= 0 && r < R && c >= 0 && c < C;
    }
}
