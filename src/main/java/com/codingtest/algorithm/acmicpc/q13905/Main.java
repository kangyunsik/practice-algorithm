package com.codingtest.algorithm.acmicpc.q13905;

import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        for (int i = 0, a, b, c; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        int ans = dijkstra(s, e);
        System.out.println(ans);
    }

    private static int dijkstra(int s, int e) {
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -i[1]));
        pq.offer(new int[]{s, Integer.MAX_VALUE});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int weight = poll[1];
            for (int[] edge : edges[cur]) {
                int nextWeight = Math.min(weight, edge[1]);
                if (dist[edge[0]] >= nextWeight) continue;
                dist[edge[0]] = nextWeight;
                pq.offer(new int[]{edge[0], nextWeight});
            }
        }
        return dist[e];
    }
}
