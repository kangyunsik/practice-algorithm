package com.codingtest.algorithm.acmicpc.q20300;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long ans;
        if (n == 1) {
            ans = arr[0];
        } else if (n == 2) {
            ans = arr[0] + arr[1];
        } else {
            Arrays.sort(arr);
            ans = getLoseValue(arr);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static long getLoseValue(long[] arr) {
        int len = arr.length;
        long max = 0;
        for (int left = 0, right = len - 1 - len % 2; left < right; left++, right--) {
            max = Math.max(max, arr[left] + arr[right]);
        }
        if (len % 2 == 1)
            return Math.max(max, arr[len - 1]);
        return max;
    }
}

