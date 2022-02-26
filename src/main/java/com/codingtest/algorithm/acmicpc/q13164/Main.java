package com.codingtest.algorithm.acmicpc.q13164;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diff = new int[n - 1];
        st = new StringTokenizer(br.readLine(), " ");
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            diff[i] = input - temp;
            temp = input;
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += diff[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
