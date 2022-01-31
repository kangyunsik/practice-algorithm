package com.codingtest.algorithm.acmicpc.q9177;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[] a, b, target;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = st.nextToken().toCharArray();
            b = st.nextToken().toCharArray();
            target = st.nextToken().toCharArray();
            dp = new int[a.length + 1][b.length + 1];
            if (solve(0, 0) > 0) {
                bw.write("Data set " + (i + 1) + ": yes\n");
            } else {
                bw.write("Data set " + (i + 1) + ": no\n");
            }
            bw.flush();
        }
    }

    private static int solve(int aHead, int bHead) {
        if(aHead == a.length && bHead == b.length) return 1;
        if(dp[aHead][bHead] != 0) return dp[aHead][bHead];

        int ret = -1;
        if (aHead < a.length && bHead < b.length &&
                a[aHead] == target[aHead + bHead] && b[bHead] == target[aHead + bHead]) {
            ret = (solve(aHead + 1, bHead) + solve(aHead, bHead + 1) == -2) ? -1 : 1;
        } else if (aHead < a.length && a[aHead] == target[aHead + bHead]) {
            ret = solve(aHead + 1, bHead);
        } else if (bHead < b.length && b[bHead] == target[aHead + bHead]) {
            ret = solve(aHead, bHead + 1);
        }
        return dp[aHead][bHead] = ret;
    }
}
