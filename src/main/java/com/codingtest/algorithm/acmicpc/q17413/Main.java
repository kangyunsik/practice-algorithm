package com.codingtest.algorithm.acmicpc.q17413;

import java.io.*;
import java.util.*;

public class Main {
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        input = br.readLine().toCharArray();
        int len = input.length;
        Stack<Character> stack = new Stack<>();
        Queue<Character> bracket = new LinkedList<>();
        boolean flag = false;
        for (char item : input) {
            if (item == '>') {
                flag = false;
                sb.append('<');
                while (!bracket.isEmpty()) sb.append(bracket.poll());
                sb.append('>');
            } else if (flag) {
                bracket.offer(item);
            } else if (item == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            } else if (item == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
