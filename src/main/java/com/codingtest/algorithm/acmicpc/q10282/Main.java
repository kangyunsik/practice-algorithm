package com.codingtest.algorithm.acmicpc.q10282;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int dest, cost;

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static List<Node>[] edges;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0, a, b, c; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                edges[b].add(new Node(a, c));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(C, 0));
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[C] = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                for (Node next : edges[cur.dest]) {
                    int nCost = cur.cost + next.cost;
                    if(dist[next.dest] <= nCost) continue;
                    dist[next.dest] = nCost;
                    pq.offer(new Node(next.dest, nCost));
                }
            }

            int max = 0, cnt = 0;
            for (int i : dist) {
                if(i != Integer.MAX_VALUE){
                    max = Math.max(max, i);
                    cnt++;
                }
            }
            sb.append(cnt).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}