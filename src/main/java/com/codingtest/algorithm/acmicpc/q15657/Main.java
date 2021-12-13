package com.codingtest.algorithm.acmicpc.q15657;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int n, m;
    static int[] values;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(values);
        find(0,new Stack<>());
        bw.flush();
    }

    private static void find(int cur, Stack<Integer> stack) throws IOException {
        if(stack.size() == m){
            for (Integer value : stack) {
                bw.write(value+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = cur; i < n; i++) {
            stack.push(values[i]);
            find(i,stack);
            stack.pop();
        }
    }
}

