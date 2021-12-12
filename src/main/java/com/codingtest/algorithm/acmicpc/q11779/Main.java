package com.codingtest.algorithm.acmicpc.q11779;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer>[] edges;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int a, b, c;
        edges = new HashMap[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashMap<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            edges[a].put(b, Integer.min(edges[a].getOrDefault(b, c), c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;
        dijkstra(a, b);
    }

    static void dijkstra(int begin, int end) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[begin] = 0;
        int[] before = new int[n];
        before[begin] = begin;

        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Index(begin, 0));
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(poll.cost > dist[poll.dest]) continue;
            for (Integer nDest : edges[poll.dest].keySet()) {
                int nCost = edges[poll.dest].get(nDest) + poll.cost;
                if(nCost < dist[nDest]){
                    dist[nDest] = nCost;
                    pq.offer(new Index(nDest, nCost));
                    before[nDest] = poll.dest;
                }
            }
        }

        Stack<Integer> answer= new Stack<>();
        bw.write(dist[end]+"\n");
        while(before[end] != end){
            answer.add(end+1);
            end = before[end];
        }
        answer.add(begin+1);
        bw.write(answer.size()+"\n");
        while(!answer.isEmpty()){
            bw.write(answer.pop()+" ");
        }
        bw.flush();
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