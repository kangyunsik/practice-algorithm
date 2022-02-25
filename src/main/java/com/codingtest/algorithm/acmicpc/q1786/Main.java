package com.codingtest.algorithm.acmicpc.q1786;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String pattern = br.readLine();
        int patternLen = pattern.length();
        pi = new int[patternLen];

        setPi(pattern);
        List<Integer> list = getPatternMatchLocations(input, pattern, patternLen);

        bw.append(String.valueOf(list.size())).append("\n");
        for (Integer val : list) {
            bw.append(String.valueOf(val)).append("\n");
        }
        bw.flush();
    }

    private static List<Integer> getPatternMatchLocations(String input, String pattern, int patternLen) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0, len = input.length(); i < len; i++) {
            while (j > 0 && input.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if (input.charAt(i) != pattern.charAt(j)) continue;
            if (++j == patternLen) {
                list.add(i - j + 2);
                j = pi[j-1];
            }
        }
        return list;
    }

    private static void setPi(String pattern) {
        for (int i = 1, j = 0, len = pattern.length(); i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) pi[i] = ++j;
        }
    }
}
