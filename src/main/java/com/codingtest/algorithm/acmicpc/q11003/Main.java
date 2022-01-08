package com.codingtest.algorithm.acmicpc.q11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] values = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        br.close();

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && values[deque.getLast()] > values[i]){
                deque.removeLast();
            }
            if(!deque.isEmpty() && i - l >= deque.getFirst()){
                deque.removeFirst();
            }
            deque.add(i);
            ans.append(values[deque.getFirst()]).append(" ");
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
    }
}
