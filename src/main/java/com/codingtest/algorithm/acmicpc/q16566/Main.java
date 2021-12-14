package com.codingtest.algorithm.acmicpc.q16566;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, m, k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st.nextToken();
        boolean[] input = new boolean[n + 1];
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            input[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 0; i < n; i++) {
            if (input[i])
                set.add(i);
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int in = Integer.parseInt(st.nextToken());
            Integer temp = set.higher(in);
            if (temp == null) {
                temp = set.first();
            }
            bw.write(temp + "\n");
            set.remove(temp);
        }
        bw.flush();
    }
}
