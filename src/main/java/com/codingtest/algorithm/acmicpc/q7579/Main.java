package com.codingtest.algorithm.acmicpc.q7579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] mem;
        int[] cost;
        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        mem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
               if(dp[j] >= 0){
                   int exp = Math.min(m, j + mem[i]);
                   dp[exp] = Math.min(dp[j] + cost[i], dp[exp] < 0 ? Integer.MAX_VALUE : dp[exp]);
               }
            }
        }

        bw.write(dp[m] + "\n");
        bw.flush();
        bw.close();

    }
}