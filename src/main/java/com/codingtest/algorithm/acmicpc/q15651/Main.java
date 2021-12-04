package com.codingtest.algorithm.acmicpc.q15651;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        find(array, 0, new Stack<>());
        bw.flush();
    }

    private static void find(int[] array, int depth, Stack<Integer> stack) throws IOException {
        if(depth == m){
            for (Integer val : stack) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            stack.push(array[i]);
            find(array, depth+1, stack);
            stack.pop();
        }
    }
}
