package com.codingtest.algorithm.acmicpc.q10971;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int[] selected;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        selected = new int[n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0, new boolean[n]);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void perm(int cur, boolean[] already) {
        if (cur == n) {
            int tmp = 0;
            for (int i = 0; i < n - 1; i++) {
                int one = selected[i];
                int two = selected[i + 1];
                if (dist[one][two] == 0) return;
                tmp += dist[one][two];
            }
            if (dist[selected[n-1]][selected[0]] == 0) return;
            tmp += dist[selected[n-1]][selected[0]];
            ans = Math.min(ans, tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (already[i]) continue;
            selected[cur] = i;
            already[i] = true;
            perm(cur + 1, already);
            already[i] = false;
        }
    }
}
