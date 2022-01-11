package com.codingtest.algorithm.acmicpc.q2463;

import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int[] parent, cnt;
    static int n, m, a, b, c;
    static final int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long sum = 0L, cost;
        parent = new int[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(cnt, 1);
        Map<Integer, Integer>[] temp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new HashMap<>();
        }
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            if(a > b){ int pt = a; a = b; b = pt; }
            temp[a].put(b, Math.min(temp[a].getOrDefault(b, Integer.MAX_VALUE), c));
        }

        for (int i = 0; i < n; i++) {
            for (Integer nodeX : temp[i].keySet()) {
                Integer value = temp[i].get(nodeX);
                edges.add(new Edge(i, nodeX, value));
                sum += value;
            }
        }
        Collections.sort(edges, Comparator.comparing(e -> -e.cost));

        cost = sum;
        for (Edge edge : edges) {
            union(edge.x, edge.y, cost);
            cost -= edge.cost;
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static void union(int x, int y, long cost) {
        x = getParent(x);
        y = getParent(y);
        if(x == y) return;

        ans += ((((long)cnt[x] * cnt[y]) % mod) * cost) % mod;
        ans %= mod;
        if (x > y) {
            cnt[y] += cnt[x];
            parent[x] = y;
        } else {
            cnt[x] += cnt[y];
            parent[y] = x;
        }
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }
}

class Edge {
    int x;
    int y;
    int cost;

    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}