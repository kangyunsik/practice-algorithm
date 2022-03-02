package com.codingtest.algorithm.acmicpc.q13711;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] loc = new int[n + 1];
        int input;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            loc[Integer.parseInt(st.nextToken())] = i;
        }
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input = loc[Integer.parseInt(st.nextToken())];
            int idx = Collections.binarySearch(list, input);
            if (idx < 0) idx = -idx - 1;
            if (idx == list.size()) {
                list.add(input);
            } else {
                list.set(idx, input);
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
    }
}
