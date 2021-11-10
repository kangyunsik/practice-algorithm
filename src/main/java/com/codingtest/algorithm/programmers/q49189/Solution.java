package com.codingtest.algorithm.programmers.q49189;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Set<Integer>[] edges = new HashSet[n+1];
        boolean[] visit = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            edges[i+1] = new HashSet<>();
        }

        for (int[] ints : edge) {
            edges[ints[0]].add(ints[1]);
            edges[ints[1]].add(ints[0]);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for (Integer next : edges[1]) {
            dist[next] = 1;
        }
        dist[1] = 0;
        Queue<Index> pq = new LinkedList<>();
        pq.offer(new Index(1,0));
        while(!pq.isEmpty()){
            Index poll = pq.poll();
            if(!visit[poll.dest] && poll.cost <= dist[poll.dest]){
                for (Integer tDest : edges[poll.dest]) {
                    if(dist[tDest] > poll.cost){
                        dist[tDest] = 1 + poll.cost;
                        pq.offer(new Index(tDest, dist[tDest]));
                    }
                }
            }

            visit[poll.dest] = true;
        }

        int max = 0;
        int count = 0;
        for (int d : dist) {
            if (d != Integer.MAX_VALUE) {
                if (max < d) {
                    max = d;
                    count = 1;
                } else if (max == d) {
                    count++;
                }
            }
        }

        return count;
    }

    class Index{
        int dest;
        int cost;

        public Index(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}