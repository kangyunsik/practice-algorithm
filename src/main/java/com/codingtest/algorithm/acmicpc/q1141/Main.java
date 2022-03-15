package com.codingtest.algorithm.acmicpc.q1141;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }
        Arrays.sort(inputs, Comparator.comparingInt(String::length));
        List<String> list = new ArrayList<>();
        lb:
        for (int i = n - 1; i >= 0; i--) {
            for (String s : list) {
                if(s.startsWith(inputs[i])) continue lb;
            }
            list.add(inputs[i]);
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
    }
}
