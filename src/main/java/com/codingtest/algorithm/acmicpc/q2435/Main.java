package com.codingtest.algorithm.acmicpc.q2435;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += input[i];
        }
        int ans = sum;

        for (int i = k; i < n; i++) {
            sum += input[i];
            sum -= input[i - k];
            ans = Math.max(ans, sum);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
