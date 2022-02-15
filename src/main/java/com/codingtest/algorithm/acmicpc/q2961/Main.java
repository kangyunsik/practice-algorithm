package com.codingtest.algorithm.acmicpc.q2961;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] b;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < 1 << n; i++) {
            ans = Math.min(ans, findCases(i));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int findCases(int flag) {
        int bad = 1;
        int great = 0;
        for (int i = 0; i < n; i++) {
            if ((flag & 1 << i) > 0) {
                bad *= a[i];
                great += b[i];
            }
        }
        return Math.abs(bad - great);
    }
}
