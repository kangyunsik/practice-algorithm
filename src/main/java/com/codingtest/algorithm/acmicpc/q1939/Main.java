package com.codingtest.algorithm.acmicpc.q1939;

import java.io.*;
import java.util.*;

public class Main {
    public static final int WEIGHT_BOUND = 1000000000;
    static List<int[]>[] edges;
    static int n, begin, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine(), " ");
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(binarySearch(1, WEIGHT_BOUND + 1)));
        bw.flush();
    }

    private static int binarySearch(int s, int e) {
        int ans = -1;
        int mid;
        while (s < e) {
            mid = (s + e) / 2;
            if (bfs(mid)) {
                ans = mid;
                s = mid;
                if (s == e - 1) break;
            } else {
                e = mid;
            }
        }
        return ans;
    }

    private static boolean bfs(int threshold) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(begin);
        boolean[] visit = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] nextEdge : edges[cur]) {
                int nextDest = nextEdge[0];
                int nextWeight = nextEdge[1];
                if (threshold <= nextWeight && !visit[nextDest]) {
                    visit[nextDest] = true;
                    queue.offer(nextDest);
                }
            }
        }
        return visit[end];
    }
}
