package com.codingtest.algorithm.acmicpc.q3273;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n, x, answer = 0;
        Set<Integer> set = new HashSet<>();
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        x = Integer.parseInt(br.readLine());
        br.close();
        for (Integer value : set) {
            if(value != x - value && set.contains(x-value)){
                answer++;
            }
        }
        bw.write(answer/2+"");
        bw.flush();
        bw.close();
    }
}
