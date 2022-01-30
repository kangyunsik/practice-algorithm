package com.codingtest.algorithm.acmicpc.q3015;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        long ans = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int[] cur = {values[i], 1};
            while(!stack.isEmpty() && stack.peek()[0] <= cur[0]){
                ans += stack.peek()[1];
                cur[1] += stack.peek()[0] == cur[0] ?
                        stack.peek()[1] : 0;
                stack.pop();
            }
            ans += stack.isEmpty() ? 0 : 1;
            stack.push(cur);
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
