package com.codingtest.algorithm.acmicpc.q22973;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long k = Math.abs(Long.parseLong(br.readLine()));
        bw.write(k == 0 ? "0" : (k % 2 == 0) ? "-1" : String.valueOf(Long.toBinaryString(k).length()));
        bw.flush();
    }
}