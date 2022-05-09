package com.codingtest.algorithm.acmicpc.q3176;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge {

        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<Edge>[] edges;
    static int[][] parent, max, min;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        parent = new int[n + 1][20];
        max = new int[n + 1][20];
        min = new int[n + 1][20];
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

        int root = 1;
        dfs(root, 0, 0, 0);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int[] ans = getMinMax(a, b);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.print(sb);
    }

    private static int[] getMinMax(int a, int b) {
        int diff = Math.abs(depth[a] - depth[b]);
        boolean isA = depth[a] > depth[b];
        int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
        int d = log2(diff);

        for (int i = 0; i <= d; i++, diff >>= 1) {
            if ((diff & 1) == 0) {
                continue;
            }
            if (isA) {
                minV = Math.min(minV, min[a][i]);
                maxV = Math.max(maxV, max[a][i]);
                a = parent[a][i];
            } else {
                minV = Math.min(minV, min[b][i]);
                maxV = Math.max(maxV, max[b][i]);
                b = parent[b][i];
            }
        }

        if (a == b) {
            return new int[]{minV, maxV};
        }

        for (int i = log2(depth[a]); i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                minV = Math.min(minV, Math.min(min[a][i], min[b][i]));
                maxV = Math.max(maxV, Math.max(max[a][i], max[b][i]));
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        minV = Math.min(minV, Math.min(min[a][0], min[b][0]));
        maxV = Math.max(maxV, Math.max(max[a][0], max[b][0]));
        return new int[]{minV, maxV};
    }

    private static void dfs(int cur, int par, int dep, int cost) {
        depth[cur] = ++dep;
        parent[cur][0] = par;
        max[cur][0] = cost;
        min[cur][0] = cost;

        int mxBound = log2(dep);
        for (int i = 1; i <= mxBound; i++) {
            parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
            max[cur][i] = Math.max(max[cur][i - 1], max[parent[cur][i - 1]][i - 1]);
            min[cur][i] = Math.min(min[cur][i - 1], min[parent[cur][i - 1]][i - 1]);
        }

        for (Edge edge : edges[cur]) {
            int child = edge.v;
            if (child == par) {
                continue;
            }
            dfs(child, cur, dep, edge.cost);
        }
    }

    private static int log2(int n) {
        if (n == 0) {
            return -1;
        }
        return (int) (Math.log(n) / Math.log(2));
    }
}