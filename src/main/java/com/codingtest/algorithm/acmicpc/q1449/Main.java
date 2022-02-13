package com.codingtest.algorithm.acmicpc.q1449;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        boolean[] fault = new boolean[1001];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            fault[Integer.parseInt(st.nextToken())] = true;
        }

        int ans = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!fault[i]) continue;
            ans++;
            i += l - 1;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
