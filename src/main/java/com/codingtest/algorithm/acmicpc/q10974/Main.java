package com.codingtest.algorithm.acmicpc.q10974;

import java.io.*;

public class Main {
    static int n;
    static int[] selected;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        selected = new int[n + 1];
        isSelected = new boolean[n + 1];
        perm(1);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void perm(int cur) {
        if (cur > n) {
            for (int i = 1; i <= n; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(isSelected[i]) continue;
            selected[cur] = i;
            isSelected[i] = true;
            perm(cur + 1);
            isSelected[i] = false;
        }
    }
}
