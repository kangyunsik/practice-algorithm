package com.codingtest.algorithm.acmicpc.q2666;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int a;
        int b;
        int req;

        public Node(int a, int b, int req) {
            this.a = a;
            this.b = b;
            this.req = req;
        }
    }

    static final int[] da = {0, 0, 1, -1};
    static final int[] db = {1, -1, 0, 0};
    static int n, m;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());
        seq = new int[m];

        for (int i = 0; i < m; i++) {
            seq[i] = Integer.parseInt(br.readLine()) - 1;
        }
        int req = 0;
        while (req < m && (seq[req] == a || seq[req] == b)) {
            req++;
        }
        if (req == m) System.out.println("0");
        else System.out.println(bfs(a, b, req));
    }

    private static boolean isInvalidRange(int a, int b) {
        return a < 0 || b < 0 || a >= n || b >= n;
    }

    private static int bfs(int a, int b, int req) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[n][n][m];
        visit[a][b][req] = true;
        queue.offer(new Node(a, b, req));
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int na = poll.a + da[j];
                    int nb = poll.b + db[j];
                    if (isInvalidRange(na, nb) || na == nb) continue;
                    int nextReq = poll.req;
                    while (seq[nextReq] == na || seq[nextReq] == nb) {
                        if (++nextReq >= m) return dist;
                    }
                    if (visit[na][nb][nextReq]) continue;
                    visit[na][nb][nextReq] = true;
                    queue.offer(new Node(na, nb, nextReq));
                }
            }
        }
        return -1;
    }
}
