package com.codingtest.algorithm.acmicpc.q12101;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int cnt = 0;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        findCases(0);
        if(ans.length() == 0){
            bw.write("-1");
        }else{
            bw.write(ans.toString());
        }
        bw.flush();
    }

    private static void findCases(int cur) {
        if (cur > n || cnt > k) {
            return;
        } else if (cur == n) {
            if (++cnt == k) {
                for (Integer integer : stack) {
                    ans.append(integer).append("+");
                }
                ans.setLength(ans.length() - 1);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            stack.push(i);
            findCases(cur + i);
            stack.pop();
        }
    }
}
