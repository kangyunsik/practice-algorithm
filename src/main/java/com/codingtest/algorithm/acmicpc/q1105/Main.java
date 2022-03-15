package com.codingtest.algorithm.acmicpc.q1105;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        int ans = 0;
        if (s1.length() == s2.length()) {
            ans = calc(s1, s2);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int calc(String s1, String s2) {
        int ret = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '8') ret++;
            else if(s1.charAt(i) != s2.charAt(i)) break;
        }
        return ret;
    }
}
