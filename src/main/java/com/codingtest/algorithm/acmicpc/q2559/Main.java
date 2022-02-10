package com.codingtest.algorithm.acmicpc.q2559;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] sum = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int ans = sum[k - 1];
        for (int i = k; i < n; i++) {
            ans = Math.max(ans, sum[i] - sum[i - k]);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
