package com.codingtest.algorithm.acmicpc.q20040;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) {
                ans = i + 1;
                break;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }
}
