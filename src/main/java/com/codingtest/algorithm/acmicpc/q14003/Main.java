package com.codingtest.algorithm.acmicpc.q14003;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] values = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] indexes = new int[n];
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        list.add(values[0]);
        indexes[0] = 0;
        for (int i = 1; i < n; i++) {
            int expect = Collections.binarySearch(list, values[i]);
            if (expect < 0) {
                expect = -expect - 1;
            }
            indexes[i] = expect;
            if (expect >= list.size()) {
                list.add(values[i]);
            } else {
                list.set(expect, values[i]);
            }
        }

        bw.write(list.size() + "\n");
        int cnt = list.size() - 1;
        for (int i = n - 1; i >= 0 && cnt >= 0; i--) {
            if (indexes[i] == cnt){
                stack.push(values[i]);
                cnt--;
            }
        }
        while(!stack.isEmpty()) bw.write(stack.pop()+" ");
        bw.flush();
    }
}
