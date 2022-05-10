package com.codingtest.algorithm.acmicpc.q1761;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {

        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<Edge>[] edges;
    static int[][] parent, cost;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        parent = new int[n + 1][20];
        cost = new int[n + 1][20];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, a, b, c; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
        dfs(1, 0, 0, 0);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(find(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a, int b) {
        int diff = Math.abs(depth[a] - depth[b]);
        boolean isA = depth[a] > depth[b];
        int ret = 0;
        for (int i = 0; diff > 0; i++, diff >>= 1) {
            if ((diff & 1) == 0) {
                continue;
            }
            if (isA) {
                ret += cost[a][i];
                a = parent[a][i];
            } else {
                ret += cost[b][i];
                b = parent[b][i];
            }
        }

        if (a == b) {
            return ret;
        }

        for (int i = log2(depth[a]); i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) {
                continue;
            }
            ret += cost[a][i];
            ret += cost[b][i];
            a = parent[a][i];
            b = parent[b][i];
        }
        ret += cost[a][0];
        ret += cost[b][0];
        return ret;
    }

    private static void dfs(int cur, int par, int dep, int c) {
        depth[cur] = dep;
        parent[cur][0] = par;
        cost[cur][0] = c;

        int mxBound = log2(dep);
        for (int i = 1; i <= mxBound; i++) {
            parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
            cost[cur][i] = cost[cur][i - 1] + cost[parent[cur][i - 1]][i - 1];
        }

        for (Edge edge : edges[cur]) {
            int child = edge.v;
            int tc = edge.cost;
            if (child == par) {
                continue;
            }
            dfs(child, cur, dep + 1, tc);
        }
    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}