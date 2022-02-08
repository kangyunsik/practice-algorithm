package com.codingtest.algorithm.acmicpc.q1720;

import java.io.*;

public class Main {
    static int[] Fs = new int[31];
    static int[] Gs = new int[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Fs[1] = Gs[0] = Gs[1] = Gs[3] = 1;
        Fs[2] = Gs[2] = 3;
        int ans = (getF(n) + getG(n))/2;
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int getF(int n) {
        if (Fs[n] != 0) return Fs[n];
        return getF(n - 1) + getF(n - 2) * 2;
    }

    private static int getG(int n) {
        if (Gs[n] != 0) return Gs[n];
        return getG(n - 2) + getG(n - 4) * 2;
    }
}
