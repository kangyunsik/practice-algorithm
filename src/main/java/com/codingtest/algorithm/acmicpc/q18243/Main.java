package com.codingtest.algorithm.acmicpc.q18243;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        String ans = "Small World!";
        for (int i = 1; i <= n; i++) {
            if (bfs(i)) {
                ans = "Big World!";
                break;
            }
        }
        System.out.println(ans);
    }

    private static boolean bfs(int begin) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{begin, 0});
        boolean[] visit = new boolean[n + 1];
        visit[begin] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[1] > 6) return true;
            for (Integer next : edges[poll[0]]) {
                if (visit[next]) continue;
                cnt++;
                visit[next] = true;
                queue.offer(new int[]{next, poll[1] + 1});
            }
        }
        return cnt != n;
    }
}
