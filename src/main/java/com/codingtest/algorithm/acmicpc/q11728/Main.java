package com.codingtest.algorithm.acmicpc.q11728;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n, m;
        int[] A, B, T;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n];
        B = new int[m];
        T = new int[n + m];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0, b = 0, t = 0;
        while (a < n && b < m) {
            if (A[a] < B[b]) T[t++] = A[a++];
            else T[t++] = B[b++];
        }

        while (a < n) T[t++] = A[a++];
        while (b < m) T[t++] = B[b++];

        for (int i = 0; i < t; i++) {
            bw.write(T[i]+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
