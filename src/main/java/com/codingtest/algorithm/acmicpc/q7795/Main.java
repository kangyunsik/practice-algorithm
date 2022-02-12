package com.codingtest.algorithm.acmicpc.q7795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] left = new int[n];
            int[] right = new int[m + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                left[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                right[i + 1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(left);
            Arrays.sort(right);
            int ans = 0;
            int rightIdx = m;
            for (int leftIdx = n - 1; leftIdx >= 0; leftIdx--) {
                while (rightIdx != 0 && right[rightIdx] >= left[leftIdx]) {
                    rightIdx--;
                }
                ans += rightIdx;
            }

            bw.write(String.valueOf(ans));
            bw.write("\n");
            bw.flush();
        }
    }
}
