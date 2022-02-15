package com.codingtest.algorithm.acmicpc.q1931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int endTime, ans = 1;
        int[][] conference = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            conference[i][0] = Integer.parseInt(st.nextToken());
            conference[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(conference, (c1, c2) -> c1[1] == c2[1] ? c1[0] - c2[0] : c1[1] - c2[1]);
        endTime = conference[0][1];
        for (int i = 1; i < n; i++) {
            if (endTime <= conference[i][0]) {
                endTime = conference[i][1];
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
