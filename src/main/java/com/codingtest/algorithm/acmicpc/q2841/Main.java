package com.codingtest.algorithm.acmicpc.q2841;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stacks[i] = new Stack<>();
        }

        int ans = 0;
        for (int i = 0, a, b; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = stacks[a];
            while(!stack.isEmpty() && stack.peek() > b){
                stack.pop();
                ans++;
            }
            if(stack.isEmpty() || stack.peek() != b){
                ans++;
                stack.push(b);
            }
        }
        System.out.println(ans);
    }
}