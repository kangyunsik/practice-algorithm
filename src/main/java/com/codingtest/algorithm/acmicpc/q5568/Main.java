package com.codingtest.algorithm.acmicpc.q5568;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] seq, input;
    static int n, k;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        input = new int[n];
        seq = new int[k];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        findCases(0, 0);
        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static void findCases(int cur, int flag) {
        if (cur == k) {
            addSetBySeq();
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((flag & (1 << i)) == 0) {
                seq[cur] = i;
                findCases(cur + 1, flag | (1 << i));
            }
        }
    }

    private static void addSetBySeq() {
        StringBuilder sb = new StringBuilder();
        for (int i : seq) {
            sb.append(input[i]);
        }
        set.add(Integer.parseInt(sb.toString()));
    }
}
