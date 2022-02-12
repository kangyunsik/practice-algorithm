package com.codingtest.algorithm.acmicpc.q4796;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.toString(n).length();
        int ans = len * (n - (int) Math.pow(10, len - 1) + 1);
        for (int i = 1; i < len; i++) {
            ans += (int) Math.pow(10, i - 1) * i * 9;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
