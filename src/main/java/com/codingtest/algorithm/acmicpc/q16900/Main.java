package com.codingtest.algorithm.acmicpc.q16900;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String pattern = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        getPi(pattern);
        long ans = (long) pattern.length() * n - (long) (n - 1) * pi[pattern.length() - 1];
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void getPi(String pattern) {
        int len = pattern.length();
        pi = new int[len];
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) pi[i] = ++j;
        }
    }
}
