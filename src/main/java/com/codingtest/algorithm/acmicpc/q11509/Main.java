package com.codingtest.algorithm.acmicpc.q11509;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] flag = new int[1000001];
        int ans = 0;
        for (int i = 0, input; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            if (flag[input] == 0) {
                ans++;
                flag[input - 1]++;
            } else {
                flag[input]--;
                flag[input - 1]++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
