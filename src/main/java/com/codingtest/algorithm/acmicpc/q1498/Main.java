package com.codingtest.algorithm.acmicpc.q1498;

import java.io.*;

public class Main {
    static int[] pi;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        getPi(input);
        for (int i = 0; i < len; i++) {
            int pref = (i + 1) - pi[i];
            int post = pi[i];
            if (post != 0 && post % pref == 0) {
                bw.append(String.valueOf(i + 1)).append(" ")
                        .append(String.valueOf((post / pref) + 1));
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static void getPi(String input) {
        len = input.length();
        pi = new int[len];
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && input.charAt(i) != input.charAt(j)) j = pi[j - 1];
            if (input.charAt(i) == input.charAt(j)) pi[i] = ++j;
        }
    }
}
