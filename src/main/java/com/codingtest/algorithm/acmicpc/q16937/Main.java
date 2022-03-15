package com.codingtest.algorithm.acmicpc.q16937;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] sq = new int[n][2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sq[i][0] = Integer.parseInt(st.nextToken());
            sq[i][1] = Integer.parseInt(st.nextToken());
            for (int j = i - 1; j >= 0; j--) {
                for (int k = 0; k < 4; k++) {
                    ans = Math.max(ans,
                            getDupArea(sq[i][k % 2], sq[i][(k + 1) % 2], sq[j][k / 2], sq[j][1 - k / 2]));
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getDupArea(int x1, int y1, int x2, int y2) {
        if ((w >= y1 && x2 <= h - x1 && y2 <= w)
                || (h >= y1 && x2 <= w - x1 && y2 <= h))
            return x1 * y1 + x2 * y2;
        return 0;
    }
}
