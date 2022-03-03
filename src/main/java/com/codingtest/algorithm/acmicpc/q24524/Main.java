package com.codingtest.algorithm.acmicpc.q24524;

import java.io.*;
import java.util.Arrays;

public class Main {
    final static int[] mapper = new int[128];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();
        Arrays.fill(mapper, -1);
        for (int i = 0; i < t.length(); i++) {
            mapper[t.charAt(i)] = i;
        }

        int[] seq = new int[t.length()];
        for (char c : s.toCharArray()) {
            if (mapper[c] == -1) continue;
            if (mapper[c] == 0 || seq[mapper[c] - 1] > seq[mapper[c]])
                seq[mapper[c]]++;
        }
        bw.write(String.valueOf(Arrays.stream(seq).min().getAsInt()));
        bw.flush();
    }
}
