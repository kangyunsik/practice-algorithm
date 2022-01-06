package com.codingtest.algorithm.acmicpc.q14425;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, m, ans = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<String> already = new HashSet<>();

        for (int i = 0; i < n; i++) {
            already.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            if (already.contains(br.readLine())) {
                ans++;
            }
        }
        br.close();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}