package com.codingtest.algorithm.acmicpc.q16922;

import java.io.*;

public class Main {
    static final int[] W = {1, 5, 10, 50};
    static boolean[][] visit = new boolean[1001][21];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        find(0, n);
        System.out.println(ans);
    }

    private static void find(int cur, int remain) {
        if (visit[cur][remain]) return;
        visit[cur][remain] = true;
        if (remain == 0) {
            ans++;
            return;
        }
        for (int i : W) {
            find(cur + i, remain - 1);
        }
    }
}
