package com.codingtest.algorithm.acmicpc.q2018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        long cnt = 0;
        int sum, prevSum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            sum = prevSum + Integer.parseInt(st.nextToken());
            cnt += map.getOrDefault(sum - k, 0L);
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
            prevSum = sum;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
