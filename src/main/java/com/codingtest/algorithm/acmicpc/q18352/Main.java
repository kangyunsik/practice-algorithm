package com.codingtest.algorithm.acmicpc.q18352;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static int n;
    static final int INF = 1000000000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m, k, x, a, b;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        dijkstra(x, k);
        if (sb.length() == 0)
            bw.write("-1");
        else {
            sb.setLength(sb.length() - 1);
            bw.write(sb.toString());
        }
        bw.flush();
    }

    private static void dijkstra(int x, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[x] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        queue.offer(new int[]{x, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (dist[poll[0]] < poll[1]) continue;
            dist[poll[0]] = poll[1];
            for (Integer nDest : edges[poll[0]]) {
                queue.offer(new int[]{nDest, poll[1] + 1});
            }
        }
        for (int i = 1, len = dist.length; i < len; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }
    }
}
