package com.codingtest.algorithm.acmicpc.q2011;

import java.io.*;

public class Main {

    public static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] seq = br.readLine().toCharArray();
        int len = seq.length;
        if (seq[0] == '0')
            edgeCase(bw, 0);
        if (len == 1)
            edgeCase(bw, 1);

        int[] dp = new int[5001];
        dp[0] = dp[1] = 1;
        if (isCharacter(seq[0], seq[1]) && seq[1] != '0') {
            dp[1]++;
        }
        if (seq[1] == '0' && seq[0] != '1' && seq[0] != '2')
            edgeCase(bw, 0);

        for (int i = 2; i < len; i++) {
            if (seq[i] == '0') {
                if (seq[i - 1] != '1' && seq[i - 1] != '2')
                    edgeCase(bw, 0);
                dp[i] = dp[i - 2];
            } else if (isCharacter(seq[i - 1], seq[i])) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        bw.write(String.valueOf(dp[len - 1]));
        bw.flush();
    }

    private static void edgeCase(BufferedWriter bw, int code) throws IOException {
        bw.write(String.valueOf(code));
        bw.flush();
        System.exit(0);
    }

    private static boolean isCharacter(char a, char b) {
        int sum = (a - '0') * 10 + (b - '0');
        return a != '0' && sum > 0 && sum <= 26;
    }
}
