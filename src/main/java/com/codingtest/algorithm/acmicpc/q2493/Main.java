package com.codingtest.algorithm.acmicpc.q2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] answer, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        answer = new int[n];
        height = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        height[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            while (height[stack.peek()] < height[i]) {
                stack.pop();
            }
            answer[i - 1] = stack.peek();
            stack.push(i);
        }
        for (int i : answer) sb.append(i).append(" ");
        bw.write(sb.toString());
        bw.flush();
    }
}