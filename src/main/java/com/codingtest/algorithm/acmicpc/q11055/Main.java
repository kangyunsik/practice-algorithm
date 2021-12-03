package com.codingtest.algorithm.acmicpc.q11055;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] values;
        int[] dp = new int[1001];
        int answer = 0;

        values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            dp[values[i]] = values[i];
            for (int j = 1000; j >= 0; j--) {
                if (dp[j] != 0 && values[i] > j) {
                    dp[values[i]] = Integer.max(dp[values[i]], (dp[j] + values[i]));
                }
            }
        }
        for (int i = 1; i <= 1000; i++) {
            answer = Integer.max(dp[i], answer);
        }

        bw.write(answer + "");
        bw.flush();
    }
}
