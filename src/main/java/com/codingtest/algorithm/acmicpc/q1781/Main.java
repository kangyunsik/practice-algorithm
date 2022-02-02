package com.codingtest.algorithm.acmicpc.q1781;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] == i2[1] ? i1[0] - i2[0] : i2[1] - i1[1]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = (int) (Long.parseLong(st.nextToken()) - 1);
            pq.offer(new int[]{a, b});
        }
        TreeSet<Integer> days = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            days.add(i);
        }

        int cup = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            Integer floor = days.floor(poll[0]);
            if (floor != null) {
                days.remove(floor);
                cup += poll[1];
            }
        }
        bw.write(((long)cup + n - days.size()) + "\n");
        bw.flush();
    }
}
