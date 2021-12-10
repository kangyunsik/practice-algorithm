package com.codingtest.algorithm.acmicpc.q15652;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] values;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i+1;
        }
        find(0, new Stack<>());
        bw.flush();
    }
    static void find(int depth, Stack<Integer> stack) throws IOException {
        if(stack.size() == m){
            print(stack);
            return;
        }

        for (int i = depth; i < n; i++) {
            stack.push(values[i]);
            find(i, stack);
            stack.pop();
        }
    }

    static void print(Stack<Integer> stack) throws IOException {
        for (Integer value : stack) {
            bw.write(value+" ");
        }
        bw.write("\n");
    }
}
