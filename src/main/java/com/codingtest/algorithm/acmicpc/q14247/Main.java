package com.codingtest.algorithm.acmicpc.q14247;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1;
        StringTokenizer st2;
        long[] brr = new long[n];
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            ans += Integer.parseInt(st1.nextToken());
            brr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(brr);
        for (int i = 0; i < n; i++) {
            ans += brr[i] * i;
        }
        System.out.println(ans);
    }
}