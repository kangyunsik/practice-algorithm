package com.codingtest.algorithm.acmicpc.q2705;

import java.io.*;

public class Main {
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            int cnt = 0;
            while (n > 1) {
                ans += getPalindrome(++cnt);
                n -= 2;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int getPalindrome(int v) {
        if(dp[v] != 0) return dp[v];
        if(v == 1) return 1;
        int cur = v;
        int ret = 1;
        int cnt = 0;
        while (v > 1) {
            ret += getPalindrome(++cnt);
            v -= 2;
        }
        return dp[cur] = ret;
    }
}
