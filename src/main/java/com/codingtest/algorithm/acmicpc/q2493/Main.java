package com.codingtest.algorithm.acmicpc.q2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] answer;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;

        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        heights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Node> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            Node item = new Node(heights[i], i);
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek().height < item.height) {
                    Node pop = stack.pop();
                    answer[pop.index] = item.index + 1;
                }
            }
            stack.push(item);
        }

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            answer[pop.index] = 0;
        }

        for (int i : answer) bw.write(i+" ");
        bw.flush();
    }

    static class Node{
        int height;
        int index;

        public Node(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}