package com.codingtest.algorithm.acmicpc.q20295;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] edges;
    static int[] candy, depth;
    static int[][] parent, obCandy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        candy = new int[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][20];
        obCandy = new int[n + 1][20];

        int initStatus = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
            candy[i] = Integer.parseInt(st.nextToken());
            initStatus |= 1 << candy[i];
        }

        for (int i = 0, a, b; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        int m = Integer.parseInt(br.readLine());
        boolean[] ans = new boolean[m];
        int cur, init, seq = 0;
        st = new StringTokenizer(br.readLine());
        cur = Integer.parseInt(st.nextToken());
        init = Integer.parseInt(st.nextToken());

        while ((initStatus & 1 << init) == 0) {
            if (++seq == m) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            cur = Integer.parseInt(st.nextToken());
            init = Integer.parseInt(st.nextToken());
        }
        if (seq != m) {
            ans[seq] = true;
            seq++;
        }
        dfs(cur, 0, 0);

        for (int a, b; seq < m; seq++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans[seq] = find(cur, a, b);
            cur = a;
        }

        for (boolean f : ans) {
            sb.append(f ? "PLAY" : "CRY").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean find(int a, int b, int need) {

        int diff = Math.abs(depth[a] - depth[b]);
        boolean isA = depth[a] > depth[b];

        int obtain = obCandy[a][0] | obCandy[b][0];
        for (int i = 0; diff > 0; i++, diff >>= 1) {
            if ((diff & 1) == 0) {
                continue;
            }
            if (isA) {
                obtain |= obCandy[a][i + 1];
                a = parent[a][i];
            } else {
                obtain |= obCandy[b][i + 1];
                b = parent[b][i];
            }
        }

        if (a == b) {
            return (obtain & 1 << need) > 0;
        }

        for (int i = log2(depth[a]); i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) {
                continue;
            }
            obtain |= obCandy[a][i + 1];
            obtain |= obCandy[b][i + 1];
            a = parent[a][i];
            b = parent[b][i];
        }
        obtain |= obCandy[a][1];
        obtain |= obCandy[b][1];
        return (obtain & 1 << need) > 0;
    }

    private static void dfs(int cur, int par, int dep) {
        depth[cur] = dep;
        parent[cur][0] = par;
        obCandy[cur][0] = 1 << candy[cur];
        int d = log2(dep);
        for (int i = 1; i <= d + 1; i++) {
            parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
            if (i == 1) {
                obCandy[cur][i] = obCandy[par][i - 1] | obCandy[cur][i - 1];
            } else {
                obCandy[cur][i] = obCandy[parent[cur][i - 2]][i - 1] | obCandy[cur][i - 1];
            }
        }

        for (Integer child : edges[cur]) {
            if (child == par) {
                continue;
            }
            dfs(child, cur, dep + 1);
        }
    }

    private static int log2(int n) {
        if (n == 0) {
            return -1;
        }
        return (int) (Math.log(n) / Math.log(2));
    }
}