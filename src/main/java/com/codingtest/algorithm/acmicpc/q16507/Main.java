package com.codingtest.algorithm.acmicpc.q16507;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n + 1][m + 1];
        int input;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                input = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + input;
            }
        }

        for (int i = 0, rs, cs, re, ce; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rs = Integer.parseInt(st.nextToken());
            cs = Integer.parseInt(st.nextToken());
            re = Integer.parseInt(st.nextToken());
            ce = Integer.parseInt(st.nextToken());
            int s = sum[re][ce] - sum[re][cs - 1] - sum[rs - 1][ce] + sum[rs - 1][cs - 1];
            sb.append(s / ((re - rs + 1) * (ce - cs + 1))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
