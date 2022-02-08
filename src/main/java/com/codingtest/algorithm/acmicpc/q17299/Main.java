package com.codingtest.algorithm.acmicpc.q17299;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] how = new int[1000001];
        int[] input = new int[n];
        int[] ans = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            how[input[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && how[input[stack.peek()]] < how[input[i]]){
                ans[stack.pop()] = input[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for (int a : ans) {
            sb.append(a).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
