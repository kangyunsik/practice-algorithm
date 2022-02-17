package com.codingtest.algorithm.acmicpc.q1744;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> possitive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int input;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 1) sum++;
            else if (input <= 0) negative.offer(input);
            else possitive.offer(input);
        }
        while (possitive.size() > 1) sum += possitive.poll() * possitive.poll();
        while (negative.size() > 1) sum += negative.poll() * negative.poll();
        if (!possitive.isEmpty()) sum += possitive.poll();
        if (!negative.isEmpty()) sum += negative.poll();

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
