package com.codingtest.algorithm.acmicpc.q1148;

import java.io.*;
import java.util.*;

public class Main {
    static int max, min;
    static List<int[]> words;
    static List<Character> maxCh, minCh;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        words = new ArrayList<>();
        do {
            int[] parsed = parse(input);
            words.add(parsed);
        } while (!(input = br.readLine()).equals("-"));

        maxCh = new ArrayList<>();
        minCh = new ArrayList<>();
        input = br.readLine();
        do {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            maxCh.clear();
            minCh.clear();
            simulate(input.toCharArray());
            sb.append(getFormatString()).append("\n");
        } while (!(input = br.readLine()).equals("#"));
        System.out.println(sb);
    }

    private static int[] parse(String s) {
        int[] ret = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            ret[s.charAt(i) - 'A']++;
        }
        return ret;
    }

    private static void simulate(char[] cs) {
        Arrays.sort(cs);
        char prev = '_';
        for (int i = 0; i < 9; i++) {
            char c = cs[i];
            if (prev == c) continue;
            prev = c;
            int score = getScore(cs, c);
            if (max <= score) {
                if (max != score) maxCh.clear();
                max = score;
                maxCh.add(c);
            }

            if (min >= score) {
                if (min != score) minCh.clear();
                min = score;
                minCh.add(c);
            }
        }
    }

    private static int getScore(char[] cs, char c) {
        int[] parsed = parse(new String(cs));
        int ret = 0;
        lb:
        for (int[] wordCnt : words) {
            if (wordCnt[c - 'A'] == 0) continue;
            for (int i = 0; i < 26; i++) {
                if (wordCnt[i] > parsed[i]) continue lb;
            }
            ret++;
        }
        return ret;
    }

    private static StringBuilder getFormatString() {
        StringBuilder ret = new StringBuilder();
        minCh.forEach(ret::append);
        ret.append(" ").append(min).append(" ");
        maxCh.forEach(ret::append);
        ret.append(" ").append(max);
        return ret;
    }
}