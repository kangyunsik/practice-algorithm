package com.codingtest.algorithm.acmicpc.q18310;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        long[] sum = new long[n];
        long min = Integer.MAX_VALUE;
        int ans = -1;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        sum[0] = input[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + input[i];
        }

        for (int i = 0; i < n; i++) {
            long dist = 0;
            if (i != n - 1)
                dist += sum[n - 1] - sum[i] - (long) input[i] * (n - 1 - i);
            if (i != 0)
                dist += (long) input[i] * i - sum[i - 1];
            if (dist < min) {
                min = dist;
                ans = input[i];
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
