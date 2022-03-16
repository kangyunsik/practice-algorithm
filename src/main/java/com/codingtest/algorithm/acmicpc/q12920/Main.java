package com.codingtest.algorithm.acmicpc.q12920;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        for (int i = 0, x, y, z, temp; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            int cnt = 1;
            while (z > 0) {
                temp = Math.min(z, cnt);
                for (int j = m; j >= x * temp; j--) {
                    dp[j] = Math.max(dp[j - x * temp] + y * temp, dp[j]);
                }
                cnt *= 2;
                z -= temp;
            }
        }
        bw.write(String.valueOf(dp[m]));
        bw.flush();
    }
}
