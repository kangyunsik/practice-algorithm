package com.codingtest.algorithm.acmicpc.q14469;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, Comparator.comparingInt(i -> i[0]));

        int curTime = 0;
        for (int i = 0; i < n; i++) {
            curTime = Math.max(curTime, input[i][0]);
            curTime += input[i][1];
        }
        bw.write(String.valueOf(curTime));
        bw.flush();
    }
}
