package com.codingtest.algorithm.acmicpc.q6549;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        while (n != 0) {
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            long ans = getSolution(height, 0, n);
            bw.write(ans + "\n");
            bw.flush();

            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
        }
    }

    private static long getSolution(int[] height, int s, int e) {
        if (s >= e - 1) return height[s];

        int m = (s + e) / 2;
        long left = getSolution(height, s, m);
        long right = getSolution(height, m, e);
        long comb = getComb(height, s, m, e);
        return Math.max(left, Math.max(right, comb));
    }

    private static long getComb(int[] height, int s, int m, int e) {
        int left = m;
        int right = m;
        int temp = height[m];
        long max = height[m];
        while (s < left && right < e - 1) {
            if (height[right + 1] <= height[left - 1]) {
                left--;
                temp = Integer.min(height[left], temp);
            } else {
                right++;
                temp = Integer.min(height[right], temp);
            }

            max = Math.max(max, (long) (right - left + 1) * temp);
        }

        while(s < left){
            left--;
            temp = Integer.min(height[left] , temp);
            max = Math.max(max, (long) (right - left + 1) * temp);
        }

        while(right < e-1){
            right++;
            temp = Integer.min(height[right] , temp);
            max = Math.max(max, (long) (right - left + 1) * temp);
        }

        return max;
    }
}
