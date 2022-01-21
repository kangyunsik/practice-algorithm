package com.codingtest.algorithm.acmicpc.q2533;

import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer>[] edges;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a, b;
        int n = Integer.parseInt(br.readLine());
        dp = new int[2][n];
        edges = new HashSet[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashSet<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }

        getDP(0, 1);
        getDP(0, 0);

        bw.write(Math.min(dp[0][0], dp[1][0]) + "\n");
        bw.flush();
    }

    private static void getDP(int index, int from) {
        dp[0][index] = 0;
        dp[1][index] = 1;
        for (Integer next : edges[index]) {
            if(next != from){
                getDP(next, index);
                dp[0][index] += dp[1][next];
                dp[1][index] += Math.min(dp[0][next], dp[1][next]);
            }
        }
    }
}
