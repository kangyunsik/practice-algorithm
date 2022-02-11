package com.codingtest.algorithm.acmicpc.q2467;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int input, left = 0, right = 0, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n - 1; i++) {
            input = Integer.parseInt(st.nextToken());
            int index = Collections.binarySearch(list, -input);
            if (index < 0) index = -index - 1;
            if (index > 0)
                updateAns(list, index - 1);
            if(index != list.size())
                updateAns(list, index);
            list.add(input);
        }
        bw.write(left + " " + right);
        bw.flush();
    }

    private static void updateAns(List<Integer> list, int index) {
        if (Math.abs(list.get(index) + input) < ans) {
            ans = Math.abs(list.get(index) + input);
            left = list.get(index);
            right = input;
        }
    }
}
