package com.codingtest.algorithm.acmicpc.q2644;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int a,b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        int ans = dijkstra(x, y);
        if(ans == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int dijkstra(int begin, int end){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[begin] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.offer(new int[]{begin, 0});
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(poll[1] > dist[poll[0]]) continue;
            dist[poll[0]] = poll[1];
            for (Integer next : edges[poll[0]]) {
                pq.offer(new int[]{next, poll[1] + 1});
            }
        }
        return dist[end];
    }
}
