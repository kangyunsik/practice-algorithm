package com.codingtest.algorithm.acmicpc.q13907;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer>[] edges;
    static int n,m,k;
    static int inc = 0;
    static int[][] dist;
    static final int INF = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int s,e;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        s = Integer.parseInt(st.nextToken())-1;
        e = Integer.parseInt(st.nextToken())-1;
        edges = new HashMap[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashMap<>();
        }

        int a,b,c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());
            edges[a].put(b, Math.min(edges[a].getOrDefault(b, Integer.MAX_VALUE), c));
            edges[b].put(a, Math.min(edges[b].getOrDefault(a, Integer.MAX_VALUE), c));
        }
        dijkstra(s,e);

        int min = INF;
        for (int i = 0; i < n; i++) {
            if(dist[i][e] != INF)
                min = Math.min(dist[i][e], min);
        }
        bw.write(min+"\n");

        for(int i=0;i<k;i++){
            inc += Integer.parseInt(br.readLine());
            min = INF;
            for (int j = 0; j < n; j++) {
                if(dist[j][e] != INF)
                    min = Math.min(dist[j][e] + j * inc, min);
            }
            bw.write(min+"\n");
        }
        bw.flush();
    }
    private static void dijkstra(int s, int e){
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][s] = 0;
        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(index -> index.cost));
        pq.offer(new Index(s, 0, 0));
        
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(poll.depth >= n || poll.cost > dist[poll.depth][poll.dest]) continue;

            lb:
            for (Integer nDest : edges[poll.dest].keySet()) {
                int nCost = poll.cost + edges[poll.dest].get(nDest);

                for (int i = 0; i <= poll.depth; i++) {
                    if(dist[i][nDest] < nCost){
                        continue lb;
                    }
                }
                
                if(nCost < dist[poll.depth+1][nDest]){
                    dist[poll.depth+1][nDest] = nCost;
                    pq.offer(new Index(nDest, nCost, poll.depth+1));
                }
            }
        }
    }
}

class Index{
    int dest;
    int cost;
    int depth;

    public Index(int dest, int cost, int depth) {
        this.dest = dest;
        this.cost = cost;
        this.depth = depth;
    }
}
