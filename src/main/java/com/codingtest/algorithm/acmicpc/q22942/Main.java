package com.codingtest.algorithm.acmicpc.q22942;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int x, r;
        int[] board = new int[2020001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) + 1010000;
            r = Integer.parseInt(st.nextToken());
            if (board[x - r] != 0 || board[x + r] != 0) {
                System.out.println("NO");
                return;
            } else {
                board[x - r] = (i+1);
                board[x + r] = -(i+1);
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int item : board) {
            if(item != 0){
                if(item > 0){
                    stack.push(item);
                }else if(stack.isEmpty() || stack.pop() != -item){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
