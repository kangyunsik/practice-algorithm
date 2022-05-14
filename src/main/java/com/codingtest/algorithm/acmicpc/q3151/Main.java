package com.codingtest.algorithm.acmicpc.q3151;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] con = new int[20001];
        con[arr[0] + 10000]++;
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = arr[i] + arr[j];
                if(v > 10000 || v < -10000) continue;
                ans += con[10000 - v];
            }
            con[arr[i] + 10000]++;
        }
        System.out.println(ans);
    }
}