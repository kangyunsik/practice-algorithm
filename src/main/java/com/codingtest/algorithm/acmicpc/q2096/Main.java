package com.codingtest.algorithm.acmicpc.q2096;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ansMax, ansMin;
        int[] values;
        int[][] min = new int[n][3];
        int[][] max = new int[n][3];

        min[0] = max[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < n; i++) {
            values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int left = Integer.min(min[i - 1][0], min[i - 1][1]);
            int right = Integer.min(min[i - 1][1], min[i - 1][2]);
            min[i][0] = left + values[0];
            min[i][1] = Integer.min(left, right) + values[1];
            min[i][2] = right + values[2];

            left = Integer.max(max[i - 1][0], max[i - 1][1]);
            right = Integer.max(max[i - 1][1], max[i - 1][2]);
            max[i][0] = left + values[0];
            max[i][1] = Integer.max(left, right) + values[1];
            max[i][2] = right + values[2];
        }

        ansMax = Integer.max(max[n - 1][0], Integer.max(max[n - 1][1], max[n - 1][2]));
        ansMin = Integer.min(min[n - 1][0], Integer.min(min[n - 1][1], min[n - 1][2]));
        bw.write(ansMax + " " + ansMin);
        bw.flush();
    }
}
