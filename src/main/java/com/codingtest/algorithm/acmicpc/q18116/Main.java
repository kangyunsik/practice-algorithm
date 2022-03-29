package com.codingtest.algorithm.acmicpc.q18116;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        parent = new int[1000001];
        Arrays.fill(parent, -1);
        for (int i = 0, x, y; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().equals("I")) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                union(x, y);
            } else {
                x = Integer.parseInt(st.nextToken());
                sb.append(getCount(x)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a == b) return;
        if (getCount(a) < getCount(b)) {
            parent[b] += parent[a];
            parent[a] = b;
        } else {
            parent[a] += parent[b];
            parent[b] = a;
        }
    }

    private static int getParent(int a) {
        if (parent[a] < 0) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static int getCount(int a) {
        a = getParent(a);
        return -parent[a];
    }
}
