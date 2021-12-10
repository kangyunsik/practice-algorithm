package com.codingtest.algorithm.acmicpc.q1918;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solve(br.readLine());
        bw.write(answer);
        bw.flush();
    }

    static String solve(String inOrder) {
        char[] array = inOrder.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> op = new Stack<>();

        for (char temp : array) {
            if (Character.isAlphabetic(temp)) {
                sb.append(temp);
            } else if (temp == '(') {
                op.push(temp);
            } else if (temp == ')') {
                while (!op.isEmpty() && op.peek() != '(')
                    sb.append(op.pop());
                op.pop();
            } else {
                while (!op.isEmpty() && getPriority(op.peek()) >= getPriority(temp)) {
                    sb.append(op.pop());
                }
                op.push(temp);
            }
        }

        while(!op.isEmpty()) sb.append(op.pop());

        return sb.toString();
    }

    private static int getPriority(char temp) {
        if(temp == '*' || temp == '/') return 2;
        else if(temp == '(' || temp == ')') return 0;
        return 1;
    }
}
