package com.codingtest.algorithm.acmicpc.q10819;

import java.io.*;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    static int n, ans;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findCases(new Stack<>());
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void calc(Stack<Integer> stack) {
        int ret = 0;
        for (int i = 0; i < stack.size() - 1; i++) {
            ret += Math.abs(values[stack.get(i)] - values[stack.get(i + 1)]);
        }
        ans = Math.max(ans, ret);
    }

    private static void findCases(Stack<Integer> stack) {
        if (stack.size() == n) {
            calc(stack);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!stack.contains(i)) {
                stack.push(i);
                findCases(stack);
                stack.pop();
            }
        }
    }
}
