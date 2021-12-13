package com.codingtest.algorithm.acmicpc.q15686;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n,m, answer = Integer.MAX_VALUE;
    static List<Index> homes = new ArrayList<>();
    static List<Index> seller = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                String input = st.nextToken();
                if(input.equals("1")){
                    homes.add(new Index(i,j));
                }else if(input.equals("2")){
                    seller.add(new Index(i,j));
                }
            }
        }

        recursiveSelect(0,new Stack<>());
        bw.write(answer+"");
        bw.flush();
    }

    static void recursiveSelect(int cur, Stack<Integer> stack){
        if(cur > seller.size() || stack.size() > m){
            return;
        }else if(stack.size() == m){
            answer = Integer.min(answer, calc(stack));
        }

        stack.push(cur);
        recursiveSelect(cur+1,stack);
        stack.pop();
        recursiveSelect(cur+1,stack);
    }

    static int calc(Stack<Integer> stack){
        int result = 0;
        for (Index home : homes) {
            int temp = Integer.MAX_VALUE;
            for (Integer num : stack) {
                Index one = seller.get(num);
                temp = Integer.min(temp, dist(home.x, one.x,home.y, one.y));
            }
            result+=temp;
        }
        return result;
    }

    static int dist(int x1, int x2, int y1, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}

class Index{
    int x;
    int y;
    int cost;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
        this.cost = 0;
    }
}