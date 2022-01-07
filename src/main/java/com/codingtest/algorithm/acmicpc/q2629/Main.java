package com.codingtest.algorithm.acmicpc.q2629;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int N = 80000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] w;
        boolean[] poss;
        int n = Integer.parseInt(br.readLine());
        w = new int[n];
        poss = new boolean[N+1];
        poss[N/2] = true;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.clear();
            for (int j = 0; j <= N; j++) {
                if (j - w[i] >= 0 && poss[j]) {
                    temp.add(j - w[i]);
                }
                if (j + w[i] <= N && poss[j]) {
                    temp.add(j + w[i]);
                }
            }

            for (Integer t : temp) {
                poss[t] = true;
            }
        }

        br.readLine();
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int k;
        while (st.hasMoreTokens()) {
            k = Integer.parseInt(st.nextToken());
            if (poss[k + N/2]) {
                bw.write("Y ");
            } else {
                bw.write("N ");
            }
        }
        bw.flush();
        bw.close();

    }
}
