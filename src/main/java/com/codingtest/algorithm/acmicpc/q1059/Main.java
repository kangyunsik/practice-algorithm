package com.codingtest.algorithm.acmicpc.q1059;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < s && s < arr[i + 1]) {
                ans = (s - arr[i]) * (arr[i + 1] - s) - 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
