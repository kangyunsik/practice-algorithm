package com.codingtest.algorithm.acmicpc.q15654;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n, m;
    static int[] values;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        Arrays.sort(values);
        find(0, new Stack<>());
        bw.flush();
    }

    static void find(int current, Stack<Integer> stack) throws IOException {
        if (stack.size() == m) {
            print(stack);
        }
        for (int i = 0; i < n; i++) {
            if (!stack.contains(i)) {
                stack.push(i);
                find(current + 1, stack);
                stack.pop();
            }
        }
    }

    static void print(Stack<Integer> stack) throws IOException {
        for (Integer index : stack) bw.write(values[index] + " ");
        bw.write("\n");
    }
}
