package com.codingtest.algorithm.acmicpc.q11501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            int top = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (top == -1 || top < input[i]) {
                    top = input[i];
                } else {
                    ans += top - input[i];
                }
            }

            bw.write(String.valueOf(ans));
            bw.write("\n");
            bw.flush();
        }
    }
}
