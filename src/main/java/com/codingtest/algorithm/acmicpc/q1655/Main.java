package com.codingtest.algorithm.acmicpc.q1655;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                maxHeap.offer(Integer.parseInt(br.readLine()));
            } else {
                minHeap.offer(Integer.parseInt(br.readLine()));
            }

            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }

            if (i % 2 == 0) {
                bw.write(maxHeap.peek() + "\n");
            } else {
                bw.write(Math.min(minHeap.peek(), maxHeap.peek()) + "\n");
            }
        }
        bw.flush();
    }
}
