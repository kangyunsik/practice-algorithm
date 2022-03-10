package com.codingtest.algorithm.acmicpc.q1940;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            ans += map.getOrDefault(m - input, 0);
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
