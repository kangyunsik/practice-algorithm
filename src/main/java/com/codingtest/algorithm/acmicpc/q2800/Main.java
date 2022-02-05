package com.codingtest.algorithm.acmicpc.q2800;

import java.io.*;
import java.util.*;

public class Main {
    static int bSize;
    static char[] input;
    static List<int[]> bracket;
    static List<String> ans = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        bracket = new ArrayList<>();
        for (int i = 0, len = input.length; i < len; i++) {
            char item = input[i];
            if(item == '('){
                stack.push(i);
            }else if(item == ')'){
                bracket.add(new int[]{stack.pop(), i});
            }
        }
        bSize = bracket.size();
        findCases(0, new Stack<>());
        Collections.sort(ans);
        for (String s : ans) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
    }

    public static void findCases(int cur, Stack<Integer> already){
        if(cur == bSize){
            if(already.size() > 0){
                appendAns(already);
            }
            return;
        }

        already.push(cur);
        findCases(cur + 1, already);
        already.pop();
        findCases(cur + 1, already);
    }

    public static void appendAns(Stack<Integer> seq){
        StringBuilder sb = new StringBuilder();
        char[] temp = Arrays.copyOf(input, input.length);
        for (Integer index : seq) {
            for (int i : bracket.get(index)) {
                temp[i] = ' ';
            }
        }
        for (char c : temp) {
            if(c != ' ')
                sb.append(c);
        }
        if(set.add(sb.toString())) {
            ans.add(sb.toString());
        }
    }
}
