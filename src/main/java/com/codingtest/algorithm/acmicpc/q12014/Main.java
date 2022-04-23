package com.codingtest.algorithm.acmicpc.q12014;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n, k;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0, val; i < n; i++) {
                val = Integer.parseInt(st.nextToken());
                int idx = Collections.binarySearch(list, val);
                if(idx < 0) idx = -idx - 1;
                if(list.size() == idx) list.add(val);
                else list.set(idx, val);
            }
            sb.append("Case #").append(test_case).append("\n");
            if(list.size() >= k) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }
        System.out.println(sb);
    }
}