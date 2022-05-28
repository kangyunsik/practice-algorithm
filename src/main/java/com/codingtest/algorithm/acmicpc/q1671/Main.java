package com.codingtest.algorithm.acmicpc.q1671;

import java.io.*;
import java.util.*;

public class Main {
    static class Shark implements Comparable<Shark> {
        int a, b, c;

        public Shark(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Shark o = null;
            if (obj instanceof Shark)
                o = (Shark) obj;
            return o != null && a == o.a && b == o.b && c == o.c;
        }

        @Override
        public int compareTo(Shark o) {
            if (a <= o.a && b <= o.b && c <= o.c) {
                return -1;
            } else if (a >= o.a && b >= o.b && c >= o.c) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static int[] work;
    static boolean[] visit;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Shark[] shark = new Shark[n];
        work = new int[n];
        visit = new boolean[n];
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, a, b, c; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            shark[i] = new Shark(a, b, c);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shark[i].equals(shark[j])) {
                    edges[i].add(j);
                } else if (shark[i].compareTo(shark[j]) > 0) {
                    edges[i].add(j);
                } else if (shark[j].compareTo(shark[i]) > 0) {
                    edges[j].add(i);
                }
            }
        }

        Arrays.fill(work, -1);
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            dfs(i);
            Arrays.fill(visit, false);
            dfs(i);
        }

        System.out.println(Arrays.stream(work).filter(w -> w == -1).count());
    }

    private static boolean dfs(int cur) {
        visit[cur] = true;
        for (Integer to : edges[cur]) {
            int next = work[to];
            if (next == -1 || (!visit[next] && dfs(next))) {
                work[to] = cur;
                return true;
            }
        }
        return false;
    }
}