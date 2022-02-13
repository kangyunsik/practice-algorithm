package com.codingtest.algorithm.acmicpc.q11000;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(input, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.offer(input[0]);
        for (int i = 1; i < n; i++) {
            if (pq.peek()[1] <= input[i][0]) {
                pq.poll();
            }
            pq.offer(input[i]);

        }
        bw.write(String.valueOf(pq.size()));
        bw.flush();
    }
}
