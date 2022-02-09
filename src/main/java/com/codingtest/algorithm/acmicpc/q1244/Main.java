package com.codingtest.algorithm.acmicpc.q1244;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] stat = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            stat[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int opt = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());
            if (opt == 1) {
                for (int j = input - 1; j < n; j += input) {
                    stat[j] = 1 - stat[j];
                }
            } else {
                int left = --input;
                int right = input;
                stat[input] = 1 - stat[input];
                while (left >= 0 && right < n && stat[left] == stat[right]) {
                    stat[left] = 1 - stat[left--];
                    stat[right] = 1 - stat[right++];
                }
            }
        }
        int cnt = 0;
        for (int i : stat) {
            sb.append(i).append(" ");
            if(++cnt % 20 == 0)
                sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
