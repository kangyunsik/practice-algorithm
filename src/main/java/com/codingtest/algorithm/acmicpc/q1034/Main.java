package com.codingtest.algorithm.acmicpc.q1034;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long all = (1L << m) - 1;
        for (int i = 0; i < n; i++) {
            long input = decode(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        int k = Integer.parseInt(br.readLine());

        int ans = 0;
        for (Long code : map.keySet()) {
            int needed = m - Long.bitCount(all & code);
            if(k >= needed && k % 2 == needed % 2){
                ans = Math.max(ans, map.get(code));
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static long decode(String string) {
        long ret = 0L;
        for (int i = 0; i < string.length(); i++) {
            ret *= 2;
            ret += string.charAt(i) - '0';
        }
        return ret;
    }
}
