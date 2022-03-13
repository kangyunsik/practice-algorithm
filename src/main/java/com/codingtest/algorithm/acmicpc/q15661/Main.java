package com.codingtest.algorithm.acmicpc.q15661;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 1 << n; i++) {
            ans = Math.min(ans, getDiffByFlag(i));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getDiffByFlag(int flag) {
        int score1 = 0, score2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((flag & 1 << i) == 0 && (flag & 1 << j) == 0) {
                    score1 += arr[i][j];
                }
                if ((flag & 1 << i) > 0 && (flag & 1 << j) > 0) {
                    score2 += arr[i][j];
                }
            }
        }
        return Math.abs(score1 - score2);
    }
}
