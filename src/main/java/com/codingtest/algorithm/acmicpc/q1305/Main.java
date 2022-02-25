package com.codingtest.algorithm.acmicpc.q1305;

import java.io.*;

public class Main {

    static int[] pi;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        pi = new int[n];
        String input = br.readLine();
        getPi(input);
        bw.write(String.valueOf(n - pi[n-1]));
        bw.flush();
    }

    private static void getPi(String pattern) {
        for (int i = 1, j = 0,len = pattern.length(); i < len; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if(pattern.charAt(i) == pattern.charAt(j)) pi[i] = ++j;
        }
    }
}
