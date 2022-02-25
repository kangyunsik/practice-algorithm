package com.codingtest.algorithm.acmicpc.q1893;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int[] pi;
    static char[] seq;
    static Map<Character, Integer> mapper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            seq = br.readLine().toCharArray();
            int cycleLen = seq.length;
            mapper = new HashMap<>();
            for (int i = 0; i < cycleLen; i++) {
                mapper.put(seq[i], i);
            }

            String origin = br.readLine();
            int originLen = origin.length();
            pi = new int[originLen];
            getPi(origin);

            List<Integer> indexes = new ArrayList<>();
            String target = br.readLine();
            for (int cycle = 0; cycle < cycleLen; cycle++) {
                int cnt = 0;
                for (int i = 0, j = 0, tLen = target.length(); i < tLen; i++) {
                    while (j > 0 && getReverseShift(target.charAt(i), cycle) != origin.charAt(j)) j = pi[j - 1];
                    if (getReverseShift(target.charAt(i), cycle) != origin.charAt(j)) continue;
                    if (++j == originLen) {
                        cnt++;
                        j = pi[j - 1];
                    }
                }
                if (cnt == 1) indexes.add(cycle);
            }
            printIndexAsFormat(indexes, bw);
        }
        bw.flush();
    }

    private static void printIndexAsFormat(List<Integer> indexes, BufferedWriter bw) throws IOException {
        if(indexes.size() == 0){
            bw.append("no solution");
        }else if(indexes.size() == 1){
            bw.append("unique: ").append(String.valueOf(indexes.get(0)));
        }else{
            bw.append("ambiguous: ");
            for (Integer index : indexes) {
                bw.append(String.valueOf(index)).append(" ");
            }
        }
        bw.newLine();
    }

    private static char getReverseShift(char c, int val) {
        int idx = mapper.get(c);
        return seq[(idx - val + seq.length) % seq.length];
    }

    private static void getPi(String pattern) {
        for (int i = 1, j = 0, len = pattern.length(); i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = pi[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) pi[i] = ++j;
        }
    }
}
