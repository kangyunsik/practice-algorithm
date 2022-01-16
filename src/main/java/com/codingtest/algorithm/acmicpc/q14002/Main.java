package com.codingtest.algorithm.acmicpc.q14002;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pos = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Collections.binarySearch(list, values[i]);
            if (index < 0) {
                index = -index - 1;
            }
            if (index == list.size()) {
                list.add(values[i]);
            } else {
                list.set(index, values[i]);
            }
            pos[i] = index;
        }

        Stack<Integer> ans = new Stack<>();
        int cur = list.size() - 1;
        for (int i = n - 1; cur >= 0; i--) {
            if(pos[i] == cur){
                ans.push(values[i]);
                cur--;
            }
        }
        bw.write(ans.size()+"\n");
        while(!ans.isEmpty()){
            bw.write(ans.pop()+" ");
        }
        bw.flush();

    }
}
