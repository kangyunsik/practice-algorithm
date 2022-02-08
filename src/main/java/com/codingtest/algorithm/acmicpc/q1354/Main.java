package com.codingtest.algorithm.acmicpc.q1354;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int P, Q, X, Y;
    static long N;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        bw.write(recursive(N) + "\n");
        bw.flush();
    }

    private static long recursive(long n) {
        if(n <= 0) return 1;
        if(map.containsKey(n)) return map.get(n);
        long ret = recursive(n / P - X) + recursive(n / Q - Y);
        map.put(n, ret);
        return ret;
    }
}
