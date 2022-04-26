package com.codingtest.algorithm.acmicpc.q9370;

import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 10000000;
    static List<int[]>[] edges;
    static int n, m, t, s, g, h;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            edges = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0, a, b, c; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken()) * 2;
                if ((a == g && b == h) || (a == h && b == g)) {
                    edges[a].add(new int[]{b, c - 1});
                    edges[b].add(new int[]{a, c - 1});
                } else {
                    edges[a].add(new int[]{b, c});
                    edges[b].add(new int[]{a, c});
                }
            }


            List<Integer> ans = new ArrayList<>();
            dijkstra();
            for (int i = 0, input; i < t; i++) {
                input = Integer.parseInt(br.readLine());
                if (dist[input] % 2 == 1) ans.add(input);
            }
            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            for (Integer an : ans) {
                sb.append(an).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static void dijkstra() {
        dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            if(check[cur]) continue;
            check[cur] = true;
            for (int[] ints : edges[cur]) {
                int next = ints[0];
                int nCost = poll[1] + ints[1];
                if (check[next] || dist[next] <= nCost) continue;
                dist[next] = nCost;
                pq.offer(new int[]{next, nCost});
            }
        }
    }
}