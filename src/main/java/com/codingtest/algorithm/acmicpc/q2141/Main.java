package com.codingtest.algorithm.acmicpc.q2141;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long w = 0L, s = 0L;
        int ans = 0;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            s += a[i][1];
        }
        Arrays.sort(a, Comparator.comparingInt(i -> i[0]));

        s = (s + 1) / 2;
        for (int i = 0; w < s; i++) {
            w += a[i][1];
            ans = a[i][0];
        }
        System.out.println(ans);
    }
}