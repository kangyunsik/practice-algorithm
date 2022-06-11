package com.codingtest.algorithm.acmicpc.q1595;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static List<Node>[] edges;
    static final int MAX_NODE = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        edges = new List[MAX_NODE + 1];
        for (int i = 1; i <= MAX_NODE; i++) {
            edges[i] = new ArrayList<>();
        }

        int u = 1, v, cost;
        String input = br.readLine();
        if (input == null) {
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges[u].add(new Node(v, cost));
            edges[v].add(new Node(u, cost));
            input = br.readLine();
            if (input != null) st = new StringTokenizer(input);
        }

        int[] nodeAndDist = getMostFarNodeAndDist(u);
        int node = nodeAndDist[0];
        nodeAndDist = getMostFarNodeAndDist(node);
        System.out.println(nodeAndDist[1]);
    }

    private static int[] getMostFarNodeAndDist(int begin) {
        int[] dist = new int[MAX_NODE + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(begin, 0));
        dist[begin] = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int dest = poll.dest;
            int cost = poll.cost;
            for (Node next : edges[dest]) {
                int nDest = next.dest;
                int nCost = cost + next.cost;
                if (dist[nDest] > nCost) {
                    dist[nDest] = nCost;
                    pq.offer(new Node(nDest, nCost));
                }
            }
        }

        int idx = -1;
        int max = -1;
        for (int i = 1; i <= MAX_NODE; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            if (max < dist[i]) {
                max = dist[i];
                idx = i;
            }
        }
        return new int[]{idx, max};
    }
}