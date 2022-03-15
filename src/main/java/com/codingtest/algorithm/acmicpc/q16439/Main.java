package com.codingtest.algorithm.acmicpc.q16439;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] input;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    max = Math.max(max, calcMax(i, j, k));
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int calcMax(int a, int b, int c) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += Math.max(Math.max(input[i][a], input[i][b]), input[i][c]);
        }
        return ret;
    }
}
