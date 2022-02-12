package com.codingtest.algorithm.acmicpc.q11652;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new TreeMap<>();
        long input;
        for (int i = 0; i < n; i++) {
            input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int time = 0;
        long ans = 0L;
        for (Long key : map.keySet()) {
            if(time < map.get(key)){
                time = map.get(key);
                ans = key;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
