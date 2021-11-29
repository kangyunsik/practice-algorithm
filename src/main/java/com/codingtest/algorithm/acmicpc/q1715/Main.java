package com.codingtest.algorithm.acmicpc.q1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0L;
        int value;
        while(pq.size() >= 2){
            pq.offer(value = pq.poll() + pq.poll());
            sum += value;
        }
        bw.write(sum+"");
        bw.flush();
    }
}
