package com.codingtest.algorithm.acmicpc.q9084;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[] coin, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            n = Integer.parseInt(br.readLine());
            coin = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int total = Integer.parseInt(br.readLine());
            dp = new int[total+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int c = coin[i]; c <= total; c++) {
                    if(dp[c - coin[i]] > 0){
                        dp[c] += dp[c - coin[i]];
                    }
                }
            }
            bw.write(dp[total]+"\n");
            bw.flush();
        }
    }
}
