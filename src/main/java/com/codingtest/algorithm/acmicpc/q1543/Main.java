package com.codingtest.algorithm.acmicpc.q1543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        String target = br.readLine();
        int cnt = string.length();
        string = string.replaceAll(target,"");
        bw.write((cnt - string.length())/target.length()+"\n");
        bw.flush();
    }
}
