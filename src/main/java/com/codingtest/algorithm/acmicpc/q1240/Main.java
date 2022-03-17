package com.codingtest.algorithm.acmicpc.q1240;

import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0, x, y, z; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            edges[x].add(new int[]{y, z});
            edges[y].add(new int[]{x, z});
        }

        for (int i = 0, x, y; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(dijkstra(x, y))).append("\n");
        }
        bw.flush();
    }

    private static int dijkstra(int begin, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.offer(new int[]{begin, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[begin] = 0;
        while (!pq.isEmpty()) {
            int[] idx = pq.poll();
            int dest = idx[0];
            int cost = idx[1];
            for (int[] edge : edges[dest]) {
                int nDest = edge[0];
                int nCost = cost + edge[1];
                if(dist[nDest] < nCost) continue;
                dist[nDest] = nCost;
                pq.offer(new int[]{nDest, nCost});
            }
        }
        return dist[end];
    }
}
