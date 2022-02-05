package com.codingtest.algorithm.acmicpc.q1863;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine().split(" ")[1]);
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int height : input) {
            while (!stack.isEmpty() && stack.peek() >= height) {
                if (stack.pop() != height)
                    ans++;
            }
            if(height != 0) stack.push(height);
        }

        bw.write((ans + stack.size()) + "\n");
        bw.flush();
    }
}
