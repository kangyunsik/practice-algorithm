package com.codingtest.algorithm.acmicpc.q18353;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int idx = Collections.binarySearch(list, values[i]);
            if (idx >= 0) {
                while (idx + 1 < list.size() && list.get(idx) == list.get(idx + 1)) idx++;
                if (idx == list.size())
                    list.add(idx, values[i]);
            } else {
                idx = -idx - 1;
                if (idx == list.size()) {
                    list.add(values[i]);
                } else {
                    while (idx > 0 && list.get(idx - 1) == list.get(idx)) idx--;
                    list.set(idx, values[i]);
                }
            }
        }
        bw.write(String.valueOf(n - list.size()));
        bw.flush();
    }
}
