package com.codingtest.algorithm.acmicpc.q1783;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans;
        if (n == 1) ans = 1;
        else if (n == 2) ans = min((m + 1) / 2, 4);
        else if (m < 7) ans = min(4, m);
        else ans = m - 2;
        System.out.println(ans);
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
