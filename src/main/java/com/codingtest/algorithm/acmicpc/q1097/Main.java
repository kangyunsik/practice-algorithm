package com.codingtest.algorithm.acmicpc.q1097;

import java.io.*;

public class Main {
    static String[] strings;
    static int[] seq;
    static int n, k, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        strings = new String[n];
        seq = new int[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }
        k = Integer.parseInt(br.readLine());
        findCases(0, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void findCases(int cur, int status) {
        if (cur == n) {
            if (isMagicString()) ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((status & 1 << i) > 0) continue;
            seq[cur] = i;
            findCases(cur + 1, status | 1 << i);
        }
    }

    private static boolean isMagicString() {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strings[seq[i]]);
        }
        String string = sb.toString();
        int[] pi = getPI(string);
        int len = string.length();
        for (int i = 1, j = 0; i < len * 2; i++) {
            while(j > 0 && string.charAt(i % len) != string.charAt(j)) j = pi[j - 1];
            if(string.charAt(i % len) != string.charAt(j)) continue;
            if(++j == len){
                j = pi[j - 1];
                cnt++;
            }
        }
        return cnt == k;
    }

    private static int[] getPI(String string) {
        int len = string.length();
        int[] pi = new int[len];
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && string.charAt(i) != string.charAt(j)) j = pi[j - 1];
            if (string.charAt(i) == string.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }
}
