package com.codingtest.algorithm.acmicpc.q15665;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] choice, input;
    static StringBuilder ans = new StringBuilder();
    static Set<String> already = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        choice = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        comb(0);
        bw.write(ans.toString());
        bw.flush();
    }

    private static void comb(int cur) {
        if (cur == m){
            StringBuilder sb = new StringBuilder();
            for (int i : choice) {
                sb.append(input[i]).append(" ");
            }
            if(already.add(sb.toString()))
                ans.append(sb).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            choice[cur] = i;
            comb(cur + 1);
        }
    }
}
