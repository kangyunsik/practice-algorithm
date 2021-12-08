package com.codingtest.algorithm.acmicpc.q15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i+1;
        }
        find(0,new Stack<>());
    }

    static void find(int current, Stack<Integer> cont) throws IOException {
        if(cont.size() == m) {
            print(cont);
            return;
        }
        if(current == n)
            return;

        cont.push(values[current]);
        find(current+1,cont);
        cont.pop();
        find(current+1,cont);
    }

    static void print(Stack<Integer> cont){
        for (Integer c : cont) System.out.print(c+" ");
        System.out.println();
    }
}

