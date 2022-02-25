package com.codingtest.algorithm.acmicpc.q10266;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static final String POSSIBLE = "possible";
    public static final String IMPOSSIBLE = "impossible";
    public static final int MAX = 360000;

    static int[] pi = new int[MAX];
    static boolean[] input = new boolean[MAX];
    static boolean[] pattern = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[Integer.parseInt(st.nextToken())] = true;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            pattern[Integer.parseInt(st.nextToken())] = true;
        }

        setPiArr();
        boolean find = false;
        for (int i = 0, j = 0; i < MAX * 2; i++) {
            while (j > 0 && input[i % MAX] != pattern[j]) j = pi[j - 1];
            if (input[i % MAX] != pattern[j]) continue;
            if (++j == MAX) {
                find = true;
                break;
            }
        }
        if (find) bw.write(POSSIBLE);
        else bw.write(IMPOSSIBLE);
        bw.flush();
    }

    private static void setPiArr() {
        for (int i = 1, j = 0; i < MAX; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];
            if (pattern[i] == pattern[j]) pi[i] = ++j;
        }
    }
}
