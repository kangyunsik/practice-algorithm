package com.codingtest.algorithm.acmicpc.q11508;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 3 != n % 3) {
                sum += arr[i];
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
