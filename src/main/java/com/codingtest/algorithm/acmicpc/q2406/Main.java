package com.codingtest.algorithm.acmicpc.q2406;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edges;
    static int[] parent;

    static class Edge implements Comparable<Edge> {

        int v, w, weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        edges = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int linkCnt = 0, req = n - 2, sum = 0;
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (union(a, b)) {
                linkCnt++;
                req--;
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1, cost; j <= n; j++) {
                cost = Integer.parseInt(st.nextToken());
                if (cost == 0) {
                    continue;
                }
                edges.add(new Edge(i, j, cost));
            }
        }
        Collections.sort(edges);
        for (int i = 0; i < edges.size() && linkCnt < n - 1; i++) {
            Edge edge = edges.get(i);
            if(union(edge.v, edge.w)){
                linkCnt++;
                sum += edge.weight;
                sb.append(edge.v).append(" ").append(edge.w).append("\n");
            }
        }
        System.out.println(sum + " " + req);
        System.out.println(sb);
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a == b || a == 1 || b == 1) return false;
        parent[b] = a;
        return true;
    }

    private static int getParent(int a) {
        if(a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }
}