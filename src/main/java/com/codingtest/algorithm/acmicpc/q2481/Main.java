package com.codingtest.algorithm.acmicpc.q2481;

import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static String[] mapper;
    static Map<String, Integer> rev;
    static Set<Integer>[] edges;
    static int[] dist;
    static int[] prev;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dijkstra() {
        dist = new int[n];
        prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.cost));
        pq.offer(new Index(0, 0));
        while (!pq.isEmpty()) {
            Index poll = pq.poll();
            if (dist[poll.dest] < poll.cost) continue;

            for (Integer nDest : edges[poll.dest]) {
                int nCost = poll.cost + 1;
                if (dist[nDest] > nCost) {
                    dist[nDest] = nCost;
                    prev[nDest] = poll.dest;
                    pq.offer(new Index(nDest, nCost));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        mapper = new String[n];
        rev = new HashMap<>();
        edges = new HashSet[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            mapper[i] = input;
            rev.put(input, i);
            char[] temp = input.toCharArray();
            for (int j = 0; j < k; j++) {
                temp[j] = (temp[j] == '0' ? '1' : '0');
                String sTemp = new String(temp);
                if (rev.containsKey(sTemp)) {
                    Integer index = rev.get(sTemp);
                    edges[index].add(i);
                    edges[i].add(index);
                }
                temp[j] = (temp[j] == '0' ? '1' : '0');
            }
        }

        dijkstra();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            find(Integer.parseInt(br.readLine()) - 1, new Stack<>());
            bw.write("\n");
        }
        bw.flush();
    }

    static void find(int root, Stack<Integer> print) throws IOException {
        if (dist[root] == Integer.MAX_VALUE) {
            bw.write("-1\n");
            return;
        }

        print.push(root + 1);
        if (root != 0) {
            find(prev[root], print);
        } else {
            while (!print.isEmpty()) {
                bw.write(print.pop() + " ");
            }
        }

    }
}

class Index {
    int dest;
    int cost;

    public Index(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}