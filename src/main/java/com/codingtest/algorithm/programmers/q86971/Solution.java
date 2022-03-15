package com.codingtest.algorithm.programmers.q86971;

import java.util.*;

class Solution {
    static Map<Integer, Set<Integer>> edges;
    static int answer;
    static int n;

    public int solution(int n, int[][] wires) {
        Solution.n = n;
        edges = new HashMap<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int s = wires[i][0];
            int e = wires[i][1];

            edges.computeIfAbsent(s, k -> new HashSet<>());
            edges.get(s).add(e);

            edges.computeIfAbsent(e, k -> new HashSet<>());
            edges.get(e).add(s);
        }


        for (Integer s : edges.keySet()) {
            for (Integer e : edges.get(s)) {
                answer = Math.min(Math.abs(bfs(s, e) - bfs(e, s)), answer);
            }

        }
        return answer;
    }

    private int bfs(int start, int except) {
        int result = 0;
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        check[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result++;
            for (Integer e : edges.get(poll)) {
                if (!check[e] && !(e == except && start == poll)) {
                    check[e] = true;
                    queue.add(e);
                }
            }
        }

        return result;
    }

}