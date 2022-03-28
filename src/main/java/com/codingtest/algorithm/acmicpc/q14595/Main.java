package com.codingtest.algorithm.acmicpc.q14595;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] delta = new int[n + 1];
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            delta[a]--;
            delta[b]++;
        }
        int status = delta[0];
        int ans = status == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            status += delta[i];
            if (status == 0) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();

    }
}
