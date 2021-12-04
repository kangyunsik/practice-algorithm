package com.codingtest.algorithm.acmicpc.q17298;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array;
        int[] answer;
        int n = Integer.parseInt(br.readLine());
        answer = new int[n];
        Arrays.fill(answer,-1);
        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int val = array[i];
            while(!stack.isEmpty() && stack.peek().val < val){
                answer[stack.pop().index] = val;
            }
            stack.push(new Node(val, i));
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}

class Node{
    int val;
    int index;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
