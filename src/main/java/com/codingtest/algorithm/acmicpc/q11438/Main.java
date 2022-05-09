package com.codingtest.algorithm.acmicpc.q11438;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] edges;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        parent = new int[n + 1][20];
        depth = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, a, b; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        setParent(1, 0, 0);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int LCA(int a, int b) {
        int diff = Math.abs(depth[b] - depth[a]);
        boolean isA = depth[a] > depth[b];
        int mul = 0;
        while (depth[a] != depth[b]) {
            if (diff % 2 == 1) {
                if (isA) {
                    a = parent[a][mul];
                } else {
                    b = parent[b][mul];
                }
            }
            diff /= 2;
            mul++;
        }

        if(a == b) return a;
        for (int i = log2(depth[a]); i >= 0; i--) {
            if(parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    private static void setParent(int cur, int par, int dep) {
        ++dep;
        depth[cur] = dep;
        parent[cur][0] = par;
        int mxBound = log2(dep);
        for (int i = 1; i <= mxBound; i++) {
            parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
        }

        for (Integer child : edges[cur]) {
            if (par == child) {
                continue;
            }
            setParent(child, cur, dep);
        }
    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}