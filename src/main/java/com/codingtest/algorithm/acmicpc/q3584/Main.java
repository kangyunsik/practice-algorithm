package com.codingtest.algorithm.acmicpc.q3584;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] he;
    static List<Integer>[] children;
    static int root;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            he = new int[n + 1];
            children = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                children[i] = new ArrayList<>();
            }

            for (int i = 0, a, b; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                parent[b] = a;
                children[a].add(b);
            }

            root = findRoot();
            dfs(root, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }
    }

    private static int lca(int a, int b) {
        while (he[a] != he[b]) {
            if (he[a] > he[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void dfs(int cur, int depth) {
        depth++;
        he[cur] = depth;
        for (Integer child : children[cur]) {
            dfs(child, depth);
        }
    }

    private static int findRoot() {
        for (int i = 1; i < parent.length; i++) {
            if(parent[i] == 0) return i;
        }
        return -1;
    }
}