package com.codingtest.algorithm.acmicpc.q3020;

import java.io.*;
import java.util.*;

public class Main {
    static int[] odd, even;
    static int n, h, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        len = n / 2;
        odd = new int[len];
        even = new int[len];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i / 2] = Integer.parseInt(br.readLine());
            } else {
                odd[i / 2] = Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        int top = Integer.MAX_VALUE;
        int cnt = 1;
        for (int i = 1; i <= h; i++) {
            int temp = find(even, i) + find(odd, h + 1 - i);
            if (temp < top) {
                top = temp;
                cnt = 1;
            } else if (temp == top) {
                cnt++;
            }
        }
        System.out.println(top + " " + cnt);
    }

    private static int find(int[] arr, int height) {
        int begin = 0;
        int end = len;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (arr[mid] < height) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return len - begin;
    }
}
