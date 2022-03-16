package com.codingtest.algorithm.acmicpc.q16508;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        char[] pattern = new char[91];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            pattern[input.charAt(i)]++;
        }
        int n = Integer.parseInt(br.readLine());
        char[][] strings = new char[n][];
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            costs[i] = Integer.parseInt(st.nextToken());
            strings[i] = st.nextToken().toCharArray();
        }

        int ans = Integer.MAX_VALUE;
        lb:
        for (int i = 0; i < (1 << n); i++) {
            char[] remain = new char[91];
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) == 0) continue;
                cost += costs[j];
                for (char c : strings[j]) {
                    remain[c]++;
                }
            }
            for (int j = 65; j <= 90; j++) {
                if(remain[j] < pattern[j]) continue lb;
            }
            ans = Math.min(ans, cost);
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

}
