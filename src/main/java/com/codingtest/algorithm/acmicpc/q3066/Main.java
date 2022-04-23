package com.codingtest.algorithm.acmicpc.q3066;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0, input; i < n; i++) {
                input = Integer.parseInt(br.readLine());
                int idx = Collections.binarySearch(list, input);
                if (idx < 0) idx = -idx - 1;
                if (idx == list.size()) list.add(input);
                else list.set(idx, input);
            }
            sb.append(list.size()).append("\n");
        }
        System.out.println(sb);
    }
}