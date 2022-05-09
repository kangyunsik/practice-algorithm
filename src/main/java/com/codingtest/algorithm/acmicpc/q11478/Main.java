package com.codingtest.algorithm.acmicpc.q11478;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(s.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}