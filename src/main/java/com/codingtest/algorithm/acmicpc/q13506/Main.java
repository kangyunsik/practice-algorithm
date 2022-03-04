package com.codingtest.algorithm.acmicpc.q13506;

import java.io.*;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int len = s.length();
        pi = new int[len];
        getPI(s);
        int cur = pi[len - 1];
        while (cur != 0) {
            for (int i = 1, j = 0; i < len - 1; i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
                if (s.charAt(i) != s.charAt(j)) continue;
                if (++j == cur) {
                    bw.write(s.substring(0, cur));
                    bw.flush();
                    return;
                }
            }
            cur = pi[cur - 1];
        }
        bw.write("-1");
        bw.flush();
    }

    private static void getPI(String s) {
        for (int i = 1, j = 0, len = s.length(); i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j)) pi[i] = ++j;
        }
    }
}
