package com.codingtest.algorithm.acmicpc.q1235;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        int len = input[0].length();

        Set<String> set = new HashSet<>();
        lb:
        for (int i = 0; i <= len; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                if(!set.add(input[j].substring(len-i)))
                    continue lb;
            }
            bw.write(String.valueOf(i));
            break;
        }
        bw.flush();
    }
}
