package com.codingtest.algorithm.acmicpc.q11437;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
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
        dfs(1, 0, 0);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int lca(int a, int b) {
        int diff = Math.abs(depth[a] - depth[b]);
        boolean isA = depth[a] > depth[b];

        // 6 => 110
        int idx = 0;
        while (diff > 0) {
            if ((diff & 1) == 1) {
                if (isA)
                    a = parent[a][idx];
                else {
                    b = parent[b][idx];
                }
            }
            idx++;
            diff >>= 1;
        }

        if(a == b) return a;

        int d = log2(depth[a]);
        for (int i = d; i >= 0; i--) {
            if(parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    private static void dfs(int cur, int par, int dep) {
        parent[cur][0] = par;
        depth[cur] = dep;
        int sq = log2(dep + 1);
        for (int i = 1; i <= sq; i++) {
            parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
        }

        for (Integer child : edges[cur]) {
            if (child == par) {
                continue;
            }
            dfs(child, cur, dep + 1);
        }

    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}