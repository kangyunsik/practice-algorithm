package com.codingtest.algorithm.acmicpc.q4354;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        while (!input.equals(".")) {
            int idx = getFirstFindIdx(input);
            bw.append(String.valueOf(input.length() / idx)).append("\n");
            input = br.readLine();
        }
        bw.flush();
    }

    private static int getFirstFindIdx(String input) {
        int n = input.length();
        int[] pi = new int[n];
        getPi(input, pi);

        for (int i = 1, j = 0; i < n * 2; i++) {
            while (j > 0 && input.charAt(i % n) != input.charAt(j)) j = pi[j - 1];
            if (input.charAt(i % n) != input.charAt(j)) continue;
            if (++j == n) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static void getPi(String input, int[] pi) {
        for (int i = 1, j = 0, len = input.length(); i < len; i++) {
            while (j > 0 && input.charAt(i) != input.charAt(j)) j = pi[j - 1];
            if (input.charAt(i) == input.charAt(j)) pi[i] = ++j;
        }
    }
}
