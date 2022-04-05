package com.codingtest.algorithm.acmicpc.q1139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        double ans = 0.0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -i.dist));
        pq.offer(new Node(0, 0.0));
        double[] cost = new double[1 << n];
        Arrays.fill(cost, Double.MIN_VALUE);
        cost[0] = 0.0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int status = poll.status;
            double dist = poll.dist;
            ans = Math.max(ans, dist);
            for (int i = 0; i < n; i++) {
                if ((status & 1 << i) > 0) continue;
                for (int j = i + 1; j < n; j++) {
                    if ((status & 1 << j) > 0) continue;
                    for (int k = j + 1; k < n; k++) {
                        if ((status & 1 << k) > 0) continue;
                        double nDist = dist + getArea(i, j, k);
                        int nextStatus = status | (1 << i) | (1 << j) | (1 << k);
                        if (cost[nextStatus] >= nDist) continue;
                        cost[nextStatus] = nDist;
                        pq.offer(new Node(nextStatus, nDist));
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static double getArea(int i, int j, int k) {
        int a = input[i];
        int b = input[j];
        int c = input[k];
        if (a + b <= c || b + c <= a || a + c <= b) return 0;
        double p = (a + b + c) / 2.0;
        double temp = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(temp);
    }

    static class Node {
        int status;
        double dist;

        public Node(int status, double dist) {
            this.status = status;
            this.dist = dist;
        }
    }
}
