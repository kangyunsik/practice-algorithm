package com.codingtest.algorithm.acmicpc.q1647;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        edges = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{a, b, c};
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        int cost = 0;
        for (int i = 0, cnt = 0; cnt < n - 2; i++) {
            if (getParent(edges[i][0]) == getParent(edges[i][1])) continue;
            union(edges[i][0], edges[i][1]);
            cnt++;
            cost += edges[i][2];
        }

        bw.write(String.valueOf(cost));
        bw.flush();
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int getParent(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = getParent(parent[a]);
    }
}
