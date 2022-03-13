package com.codingtest.algorithm.acmicpc.q1548;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Math.min(2, arr.length);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isValid(arr, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean isValid(int[] arr, int begin, int end) {
        for (int i = begin; i <= end - 2; i++) {
            for (int j = i + 1; j <= end - 1; j++) {
                for (int k = j + 1; k <= end; k++) {
                    if (isTriangular(arr, i, j, k)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isTriangular(int[] arr, int a, int b, int c) {
        return arr[a] + arr[b] > arr[c] && arr[a] + arr[c] > arr[b] && arr[b] + arr[c] > arr[a];
    }
}
