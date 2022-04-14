package com.codingtest.algorithm.acmicpc.q2660;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        while (a != -1 || b != -1) {
            edges[a].add(b);
            edges[b].add(a);
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        int depth, minDepth = Integer.MAX_VALUE, cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            depth = bfs(edges, i);
            if (minDepth > depth) {
                minDepth = depth;
                ans.setLength(0);
                ans.append(i).append(" ");
                cnt = 1;
            } else if (minDepth == depth) {
                ans.append(i).append(" ");
                cnt++;
            }
        }
        System.out.println(minDepth + " " + cnt);
        System.out.println(ans);
    }

    private static int bfs(List<Integer>[] edges, int begin) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[edges.length];
        queue.offer(begin);
        visit[begin] = true;
        int size;
        int depth = 0, cnt = 1;
        while (!queue.isEmpty()) {
            size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer next : edges[cur]) {
                    if (visit[next]) continue;
                    visit[next] = true;
                    cnt++;
                    queue.offer(next);
                }
            }
        }

        if (cnt != edges.length - 1) return Integer.MAX_VALUE;
        return depth - 1;
    }
}
