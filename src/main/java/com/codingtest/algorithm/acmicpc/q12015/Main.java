package com.codingtest.algorithm.acmicpc.q12015;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        int input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            int idx = Collections.binarySearch(list, input);
            if(idx < 0) idx = -idx - 1;
            if(idx == list.size()){
                list.add(input);
            }else{
                list.set(idx, input);
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
    }
}
