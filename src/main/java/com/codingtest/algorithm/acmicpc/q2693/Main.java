package com.codingtest.algorithm.acmicpc.q2693;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] input = new int[10];
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 10; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            sb.append(input[7]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
