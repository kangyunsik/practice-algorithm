package com.codingtest.algorithm.acmicpc.q22973;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long k = Long.parseLong(br.readLine());
        if (k < 0L) k = -k;
        int len = Long.toBinaryString(k).length();
        int bit = Long.bitCount(k);
        if (k == 0) {
            bw.write("0");
        } else if (len != bit && k % 2 == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(len));
        }
        bw.flush();
    }
}
