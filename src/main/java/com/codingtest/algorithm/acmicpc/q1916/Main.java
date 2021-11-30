package com.codingtest.algorithm.acmicpc.q1916;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Map<Integer, Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m, a, b, c, answer;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new HashMap[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashMap<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            edges[a].put(b, Integer.min(edges[a].getOrDefault(b,Integer.MAX_VALUE),c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        answer = dijkstra(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        bw.write(answer+"");
        bw.flush();
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        pq.offer(new Index(start,0));
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(poll.cost > dist[poll.dest]) continue;
            for (Integer nDest : edges[poll.dest].keySet()) {
                int nCost = edges[poll.dest].get(nDest) + poll.cost;
                if(nCost < dist[nDest]){
                    dist[nDest] = nCost;
                    pq.offer(new Index(nDest,nCost));
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
