package com.codingtest.algorithm.acmicpc.q1504;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer>[] edges;
    static int n;
    static final int INF = Integer.MAX_VALUE/3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int e, a, b, c, m1, m2, answer;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new HashMap[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashMap<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            edges[a].put(b, Integer.min(edges[a].getOrDefault(b, INF) , c));
            edges[b].put(a, Integer.min(edges[b].getOrDefault(a, INF) , c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        m1 = Integer.parseInt(st.nextToken()) - 1;
        m2 = Integer.parseInt(st.nextToken()) - 1;

        answer = Integer.min(dijkstra(0, m1) + dijkstra(m1, m2) + dijkstra(m2, n - 1), dijkstra(0, m2) + dijkstra(m2, m1) + dijkstra(m1, n - 1));
        if(answer >= INF)
            bw.write("-1");
        else
            bw.write(answer + "");
        bw.flush();
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Index(start, 0));
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(poll.cost > dist[poll.dest]) continue;
            for (Integer nDest : edges[poll.dest].keySet()) {
                int nCost = poll.cost + edges[poll.dest].get(nDest);
                if(nCost < dist[nDest]){
                    dist[nDest] = nCost;
                    pq.offer(new Index(nDest, nCost));
                }
            }
        }

        return dist[end];
    }
}

class Index{
    int dest;
    int cost;

    public Index(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}