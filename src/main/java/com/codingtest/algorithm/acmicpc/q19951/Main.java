package com.codingtest.algorithm.acmicpc.q19951;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] delta = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0, a, b, c; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            delta[a] += c;
            delta[b] -= c;
        }

        int curDelta = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            curDelta += delta[i];
            ans.append(arr[i] + curDelta).append(" ");
            arr[i] += curDelta;
        }
        System.out.println(ans);
    }
}
