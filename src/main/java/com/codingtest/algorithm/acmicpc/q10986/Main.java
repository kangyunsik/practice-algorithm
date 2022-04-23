package com.codingtest.algorithm.acmicpc.q10986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long ans = 0, target;
        int[] sum = new int[n + 1];
        for (int i = 1, input; i <= n; i++) {
            input = Integer.parseInt(st.nextToken()) % m;
            sum[i] = (input + sum[i - 1]) % m;
            target = map.getOrDefault(sum[i], 0L);
            ans += target;
            map.put(sum[i], target + 1L);
        }
        System.out.println(ans);
    }
}