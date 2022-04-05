package com.codingtest.algorithm.acmicpc.q1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int initStatus = 0;
        int mul = 1;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'Y') initStatus += mul;
            mul <<= 1;
        }
        k = Integer.parseInt(br.readLine());
        int ans = getMinCost(initStatus);
        System.out.println(ans);
    }

    private static int getMinCost(int initStatus) {
        if (initStatus == 0 && k != 0) return -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        int[] cost = new int[1 << n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[initStatus] = 0;
        queue.offer(new int[]{initStatus, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int status = poll[0];
            int dist = poll[1];
            if(Integer.bitCount(status) >= k) return dist;
            for (int i = 0; i < n; i++) {
                if ((status & 1 << i) > 0) continue;
                int nextStatus = status | 1 << i;
                int min = Integer.MAX_VALUE;
                for (int v = 0; v < n; v++) {
                    if ((status & 1 << v) == 0 || v == i) continue;
                    min = Math.min(min, edges[v][i]);
                }
                int nDist = dist + min;
                if(cost[nextStatus] <= nDist) continue;
                cost[nextStatus] = nDist;
                queue.offer(new int[]{nextStatus, nDist});
            }
        }
        return -1;
    }
}
