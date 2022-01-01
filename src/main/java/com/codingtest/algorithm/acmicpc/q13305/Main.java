package com.codingtest.algorithm.acmicpc.q13305;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dist = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = cost[0];
        long sum = 0L;
        for (int i = 0; i < n - 1; i++) {
            sum += (long)dist[i] * min;
            min = Math.min(min, cost[i+1]);
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}
