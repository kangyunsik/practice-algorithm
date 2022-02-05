package com.codingtest.algorithm.acmicpc.q3986;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] input;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            if (input.length % 2 == 0) {
                for (char c : input) {
                    if (stack.isEmpty() || stack.peek() != c) {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty())
                    ans++;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
