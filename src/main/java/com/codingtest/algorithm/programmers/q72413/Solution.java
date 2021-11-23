package com.codingtest.algorithm.programmers.q72413;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        long answer = Integer.MAX_VALUE;
        long[][] edges = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] fare : fares) {
            edges[fare[0]][fare[1]] = fare[2];
            edges[fare[1]][fare[0]] = fare[2];
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    edges[i][j] = Math.min(edges[i][j], edges[i][mid] + edges[mid][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, edges[s][i] + edges[i][a] + edges[i][b]);
        }

        return (int) answer;
    }
}