package com.codingtest.algorithm.acmicpc.q2887;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static int n;
    static int[] parent;
    static Point[] points;
    static List<Edge> edges;

    static class Point {
        int idx;
        int[] loc;

        public Point(int idx, int[] loc) {
            this.idx = idx;
            this.loc = loc;
        }
    }

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
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        points = new Point[n];
        for (int i = 0, a, b, c; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, new int[]{a, b, c});
        }

        edges = new ArrayList<>();
        List<Function<Point, Integer>> stand = new ArrayList<>();
        stand.add(p -> p.loc[0]);
        stand.add(p -> p.loc[1]);
        stand.add(p -> p.loc[2]);
        for (int i = 0; i < 3; i++) {
            addEdges(i, stand.get(i));
        }

        Collections.sort(edges);
        for (int i = 0, cnt = 0; cnt < n - 1; i++) {
            Edge edge = edges.get(i);
            if (union(edge.v, edge.w)) {
                ans += edge.weight;
                cnt++;
            }
        }
        System.out.println(ans);
    }

    private static void addEdges(int idx, Function<Point, Integer> func) {
        Arrays.sort(points, Comparator.comparing(func));
        for (int i = 0; i < n - 1; i++) {
            int weight = points[i + 1].loc[idx] - points[i].loc[idx];
            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
        }
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        parent[a] = b;
        return true;
    }

    private static int getParent(int a) {
        if (a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }
}