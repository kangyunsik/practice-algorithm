package com.codingtest.algorithm.acmicpc.q2638;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] already;
    static int[][] hit;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int remain = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    remain++;
                }
            }
        }

        while (remain != 0) {
            already = new boolean[n][m];
            hit = new int[n][m];
            find(0, 0);
            remain -= reduce();
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    static void find(int x, int y) {
        if (already[x][y]) {
            return;
        }
        already[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (inRange(px, py)) {
                if (map[px][py] == 1) {
                    hit[px][py]++;
                } else {
                    find(px, py);
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static int reduce() {
        int removed = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hit[i][j] >= 2) {
                    map[i][j] = 0;
                    removed++;
                }
            }
        }
        return removed;
    }
}
