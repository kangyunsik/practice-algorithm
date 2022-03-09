package com.codingtest.algorithm.acmicpc.q14225;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Set<Long> already = new HashSet<>();
        for (int i = 0; i < (1 << n); i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) sum += input[j];
            }
            already.add(sum);
        }

        long cur = 1L;
        while(already.contains(cur)) cur++;
        bw.write(String.valueOf(cur));
        bw.flush();
    }
}
