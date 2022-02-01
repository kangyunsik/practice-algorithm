package com.codingtest.algorithm.acmicpc.q10217;

import java.io.*;
import java.util.*;

public class Main {
    static Set<Position>[] edges;
    static final int INF = 1000000000;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int TEST_CASE = Integer.parseInt(br.readLine()); TEST_CASE > 0; TEST_CASE--) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int a, b, c, d;
            edges = new HashSet[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new HashSet<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                edges[a].add(new Position(b, c, d));
            }
            int ans = getTime();
            if (ans == INF) {
                bw.write("Poor KCM\n");
            } else {
                bw.write(ans + "\n");
            }
            bw.flush();
        }
    }

    private static int getTime() {
        int[][] mem = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], INF);
        }
        mem[0][0] = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0));

        while (!queue.isEmpty()) {
            Position poll = queue.poll();
            if (mem[poll.dest][poll.cost] < poll.time) continue;
            for (Position position : edges[poll.dest]) {
                int nCost = poll.cost + position.cost;
                int nTime = poll.time + position.time;
                if (nCost <= m && mem[position.dest][nCost] > nTime) {
                    mem[position.dest][nCost] = nTime;
                    queue.offer(new Position(position.dest, nCost, nTime));
                }
            }
        }

        int ans = INF;
        for (int v : mem[n - 1]) {
            ans = Math.min(ans, v);
        }
        return ans;
    }

    static class Position {
        int dest;
        int cost;
        int time;

        public Position(int dest, int cost, int time) {
            this.dest = dest;
            this.cost = cost;
            this.time = time;
        }
    }
}
