package com.codingtest.algorithm.acmicpc.q1270;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long input, ans;
        Map<Long, Integer> map;
        for (int i = 0, k; i < n; i++) {
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            ans = Long.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                input = Long.parseLong(st.nextToken());
                int cnt = map.getOrDefault(input, 0) + 1;
                if (cnt > k / 2) {
                    ans = input;
                }
                map.put(input, cnt);
            }
            if (ans == Long.MIN_VALUE) bw.write("SYJKGW");
            else bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();

    }
}
