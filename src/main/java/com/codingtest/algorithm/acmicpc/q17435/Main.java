package com.codingtest.algorithm.acmicpc.q17435;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] func;
    static int[][] multiFunc;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        func = new int[n + 1];
        multiFunc = new int[n + 1][20];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            func[i] = Integer.parseInt(st.nextToken());
            multiFunc[i][1] = func[i];
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(getValue(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getValue(int a, int b) {
        int mul = 1;
        while (a > 0) {
            if (a % 2 == 1) {
                b = getMultiFunc(b, mul);
            }
            a /= 2;
            mul++;
        }
        return b;
    }


    private static int getMultiFunc(int v, int mul) {
        if (multiFunc[v][mul] != 0) {
            return multiFunc[v][mul];
        }
        int ret = getMultiFunc(getMultiFunc(v, mul - 1), mul - 1);
        return multiFunc[v][mul] = ret;
    }
}