package com.codingtest.algorithm.acmicpc.q2166;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += (long)x[i] * y[(i+1)%n];
            sum -= (long)x[(i+1)%n] * y[i];
        }
        bw.write(String.format("%.1f",(double)Math.abs(sum)/2));
        bw.flush();
    }
}
