package com.codingtest.algorithm.acmicpc.q24523;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] input = new int[n + 1];
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        for (int i = 1; i <= n; i++) {
            int in = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && input[stack.peek()] != in)
                ans[stack.pop()] = i;
            stack.push(i);
            input[i] = in;
        }
        for (int i = 1; i <= n; i++) {
            bw.append(String.valueOf(ans[i])).append(" ");
        }
        bw.flush();
    }
}
