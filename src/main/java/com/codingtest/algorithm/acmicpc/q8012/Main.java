package com.codingtest.algorithm.acmicpc.q8012;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        edges = new List[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][20];
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
        int cur = 1, ans = 0;
        for (int i = 0, next; i < m; i++) {
            next = Integer.parseInt(br.readLine());
            int temp = find(cur, next);
            ans += temp;
            cur = next;
        }
        System.out.println(ans);
    }

    private static int find(int a, int b) {
        int ret;
        int diff = ret = Math.abs(depth[a] - depth[b]);
        boolean isA = depth[a] > depth[b];
        for (int i = 0; diff > 0; i++, diff >>= 1) {
            if (diff % 2 == 0) {
                continue;
            }
            if (isA) {
                a = parent[a][i];
            } else {
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
            a = parent[a][i];
            b = parent[b][i];
            ret += (int) Math.pow(2, i) * 2;
        }
        return ret + 2;
    }

    private static void dfs(int cur, int par, int dep) {
        depth[cur] = dep;
        parent[cur][0] = par;
        int d = log2(dep);
        for (int i = 1; i <= d; i++) {
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