package com.codingtest.algorithm.acmicpc.q2553;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            ret %= 10000000;
            while(ret % 10 == 0) {
                ret /= 10;
            }
        }
        bw.write(String.valueOf(ret % 10));
        bw.flush();
    }
}
