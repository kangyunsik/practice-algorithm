package com.codingtest.algorithm.acmicpc.q14907;

import java.io.*;
import java.util.*;

public class Main {
    static int[] required = new int[26];
    static int[] times = new int[26];
    static int[] dp = new int[26];
    static List<Integer>[] edges = new List[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 26; i++) {
            edges[i] = new ArrayList<>();
        }

        String input, bs;
        int a;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            a = st.nextToken().charAt(0) - 'A';
            times[a] = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
                bs = st.nextToken();
                for (char c : bs.toCharArray()) {
                    edges[c - 'A'].add(a);
                    required[a]++;
                }
            }
        }

        int ans = 0;
        Arrays.fill(dp, -1);
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, getTime(i));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int getTime(int vNum) {
        if (dp[vNum] != -1) return dp[vNum];
        int ret = 0;
        for (Integer prev : edges[vNum]) {
            ret = Math.max(ret, getTime(prev));
        }
        return dp[vNum] = ret + times[vNum];
    }
}