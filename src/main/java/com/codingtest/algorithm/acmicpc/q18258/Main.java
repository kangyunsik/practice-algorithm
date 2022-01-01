package com.codingtest.algorithm.acmicpc.q18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            switch (input) {
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? "1" : "0") + "\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.getLast() + "\n");
                    }
                    break;
                default:
                    queue.offer(Integer.parseInt(input.split(" ")[1]));
                    break;
            }
        }
        bw.flush();
    }
}
