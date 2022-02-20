package com.codingtest.algorithm.acmicpc.q2167;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sumArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sumArr[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < m; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int order = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2, sum;
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sum = 0;
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            for (int j = x1; j <= x2; j++) {
                sum += sumArr[j][y2];
                if (y1 != 0) sum -= sumArr[j][y1 - 1];
            }
            bw.append(String.valueOf(sum)).append("\n");
        }
        bw.flush();
    }
}
