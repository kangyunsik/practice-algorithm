package com.codingtest.algorithm.acmicpc.q17123;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] rowSum = new int[n];
            int[] colSum = new int[n];
            int input;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    input = Integer.parseInt(st.nextToken());
                    rowSum[i] += input;
                    colSum[j] += input;
                }
            }
            int[] rowDelta = new int[n + 1];
            int[] colDelta = new int[n + 1];

            int rs, re, cs, ce, v;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                rs = Integer.parseInt(st.nextToken()) - 1;
                cs = Integer.parseInt(st.nextToken()) - 1;
                re = Integer.parseInt(st.nextToken()) - 1;
                ce = Integer.parseInt(st.nextToken()) - 1;
                v = Integer.parseInt(st.nextToken());
                int cLen = ce - cs + 1;
                rowDelta[rs] += v * cLen;
                rowDelta[re + 1] -= v * cLen;
                int rLen = re - rs + 1;
                colDelta[cs] += v * rLen;
                colDelta[ce + 1] -= v * rLen;
            }

            int delta = 0;
            for (int i = 0; i < n; i++) {
                delta += rowDelta[i];
                sb.append(rowSum[i] + delta).append(" ");
            }
            sb.append("\n");
            delta = 0;
            for (int i = 0; i < n; i++) {
                delta += colDelta[i];
                sb.append(colSum[i] + delta).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
