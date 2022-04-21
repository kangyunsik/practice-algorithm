package com.codingtest.algorithm.acmicpc.q1365;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0, input; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            int idx = Collections.binarySearch(list, input);
            if (idx < 0) idx = -idx - 1;
            if(list.size() == idx) list.add(input);
            else list.set(idx, input);
        }
        System.out.println(n - list.size());
    }
}