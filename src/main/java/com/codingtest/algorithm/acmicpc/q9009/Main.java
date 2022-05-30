package com.codingtest.algorithm.acmicpc.q9009;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> fibo;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        initFibo();
        Stack<Integer> stack = new Stack<>();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            stack.clear();
            for (int i = fibo.size() - 1; i >= 0 && n > 0; i--) {
                if(n >= fibo.get(i)){
                    stack.add(fibo.get(i));
                    n -= fibo.get(i);
                }
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void initFibo() {
        fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);
        int cur = 0;
        for (int i = 2; cur < 1000000000; i++) {
            cur = fibo.get(i - 1) + fibo.get(i - 2);
            fibo.add(cur);
        }

    }
}