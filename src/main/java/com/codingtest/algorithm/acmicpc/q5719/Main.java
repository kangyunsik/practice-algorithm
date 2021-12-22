package com.codingtest.algorithm.acmicpc.q5719;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer>[] edges;
    static final int INF = 999999999;
    static int n, m;
    static List<Integer>[] prev;
    static boolean[] already;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        while (!(n == 0 && m == 0)) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            edges = new HashMap[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new HashMap<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges[a].put(b, c);
            }

            int ans = find(s,e);
            bw.write(ans+"\n");
            bw.flush();

            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
    }

    private static int find(int s, int e){
        int dist = dijkstra(s,e);
        if(dist == INF){
            return -1;
        }

        already = new boolean[n];
        removeEdges(e);

        int next;
        do {
            next = dijkstra(s, e);
            already = new boolean[n];
            removeEdges(e);
        }while(next != INF && next == dist);
        return next == INF ? -1 : next;
    }

    private static void removeEdges(int cur){
        if(already[cur]) return;
        already[cur] = true;
        for (Integer p : prev[cur]) {
            edges[p].remove(cur);
            removeEdges(p);
        }
    }

    private static int dijkstra(int s, int e){
        int[] dist = new int[n];
        prev = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            prev[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Index(s,0));
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(poll.cost > dist[poll.dest]) continue;

            for (Integer nDest : edges[poll.dest].keySet()) {
                int nCost = edges[poll.dest].get(nDest) + poll.cost;
                if(nCost < dist[nDest]){
                    dist[nDest] = nCost;
                    prev[nDest].clear();
                    prev[nDest].add(poll.dest);
                    pq.offer(new Index(nDest, nCost));
                }else if(nCost == dist[nDest]){
                    prev[nDest].add(poll.dest);
                }
            }
        }

        return dist[e];
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