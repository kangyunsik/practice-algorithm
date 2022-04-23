package com.codingtest.algorithm.acmicpc.q3745;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0, temp; i < n; i++) {
                temp = Integer.parseInt(st.nextToken());
                int idx = Collections.binarySearch(list, temp);
                if (idx < 0) idx = -idx - 1;
                if(list.size() == idx) list.add(temp);
                else list.set(idx, temp);
            }
            sb.append(list.size()).append("\n");
        }
        System.out.println(sb);
    }
}