package com.codingtest.algorithm.acmicpc.q1774;

import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Edge> edges;
    static int[][] location;
    static int[] parent;
    static int n;

    static class Edge {
        int a, b;
        double dist;

        public Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        location = new int[n][2];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        edges = new PriorityQueue<>(Comparator.comparing(e -> e.dist));
        for (int i = 0, x, y; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            location[i] = new int[]{x, y};
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double dist = getDist(location[i], location[j]);
                edges.add(new Edge(i, j, dist));
            }
        }

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        int cnt = getRootCnt() - 1;
        double ans = 0;
        while (cnt > 0) {
            Edge poll = edges.poll();
            if (union(poll.a, poll.b)) {
                ans += poll.dist;
                cnt--;
            }
        }
        bw.write(String.format("%.2f", ans));
        bw.flush();
    }

    private static int getRootCnt() {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (getParent(i) == i) ret++;
        }
        return ret;
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static double getDist(int[] pos1, int[] pos2) {
        double dx = pos1[0] - pos2[0];
        double dy = pos1[1] - pos2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
