package com.codingtest.algorithm.acmicpc.q1508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] diff;
    static int m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        diff = new int[k - 1];
        for (int i = 0; i < k - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        int begin = 0;
        int end = n + 1;
        long ans = -1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            long status = getStatus(mid);
            int cnt = Long.bitCount(status);
            if (cnt < m) {
                end = mid;
            } else {
                ans = status;
                begin = mid + 1;
            }
        }
        System.out.println(Long.toBinaryString(ans));
    }

    private static long getStatus(int term) {
        long ret = 1L;
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < k - 1; i++) {
            ret <<= 1;
            sum += diff[i];
            if (sum >= term && ++cnt <= m) {
                ret++;
                sum = 0;
            }
        }
        return ret;
    }
}
