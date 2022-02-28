package com.codingtest.algorithm.acmicpc.q12738;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = Collections.binarySearch(list, arr[i]);
            if (idx < 0) idx = -idx - 1;
            if (idx == list.size()) list.add(arr[i]);
            else list.set(idx, arr[i]);
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
    }
}
