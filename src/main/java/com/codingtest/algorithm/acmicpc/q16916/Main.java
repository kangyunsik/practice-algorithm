package com.codingtest.algorithm.acmicpc.q16916;

import java.io.*;

public class Main {
    static int[] pi;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String pattern = br.readLine();
        n = input.length();
        m = pattern.length();
        pi = new int[m];
        getPi(pattern);
        for (int i = 0, j = 0; i < n; i++) {
            while(j > 0 && input.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if(input.charAt(i) != pattern.charAt(j)) continue;
            if(++j == m){
                bw.write("1");
                bw.flush();
                return;
            }
        }
        bw.write("0");
        bw.flush();
    }

    private static void getPi(String pattern) {
        for (int i = 1, j = 0, len = pattern.length(); i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) pi[i] = ++j;
        }
    }
}
