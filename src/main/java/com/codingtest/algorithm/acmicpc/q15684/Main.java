package com.codingtest.algorithm.acmicpc.q15684;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] lope;
    static int n, m, h, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int a, b;
        lope = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            lope[a][b] = 1;
        }

        findCases(1, 1, 0);
        bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "\n");
        bw.flush();
    }

    private static void findCases(int x, int y, int depth) {
        if (ans > depth && isAnswer()) {
            ans = Math.min(ans, depth);
        }

        if (x > h || depth == 3) {
            return;
        }

        if (isPossible(x, y)) {
            lope[x][y] = 1;
            if (y == n - 1) {
                findCases(x + 1, 1, depth + 1);
            } else {
                findCases(x, y + 1, depth + 1);
            }
            lope[x][y] = 0;
        }

        if (y == n - 1) {
            findCases(x + 1, 1, depth);
        } else {
            findCases(x, y + 1, depth);
        }
    }

    private static boolean isAnswer() {
        for (int i = 1; i <= n; i++) {
            int depth = 1;
            int cur = i;
            while (depth <= h) {
                if (lope[depth][cur] == 1) {
                    cur++;
                } else if (lope[depth][cur - 1] == 1) {
                    cur--;
                }
                depth++;
            }
            if (cur != i)
                return false;
        }
        return true;
    }

    private static boolean isPossible(int x, int y) {
        return lope[x][y] == 0 && lope[x][y - 1] == 0;
    }
}
