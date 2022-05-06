package com.codingtest.algorithm.acmicpc.q2820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] children;
    static int count;
    static int[] beginRange, endRange, cost;

    static class SegmentTree {

        int begin, end, mid, cur, lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void add(int l, int r, int v) {
            propagate();
            if (r < begin || end < l) {
                return;
            } else if (l <= begin && end <= r) {
                lazy += v;
                propagate();
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
        }

        public int find(int idx) {
            propagate();
            if (idx < begin || end < idx) {
                return 0;
            } else if (begin == end) {
                return cur;
            }
            return left.find(idx) + right.find(idx);
        }

        private void propagate() {
            if (lazy == 0) {
                return;
            }
            cur += lazy;
            if (begin != end) {
                left.lazy += lazy;
                right.lazy += lazy;
            }
            lazy = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        children = new List[n + 1];
        beginRange = new int[n + 1];
        endRange = new int[n + 1];
        cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        SegmentTree root = new SegmentTree(1, n);
        cost[1] = Integer.parseInt(br.readLine());
        for (int i = 2, a, b; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost[i] = a;
            children[b].add(i);
        }
        eulerDFS(1);

        for (int i = 1; i <= n; i++) {
            root.add(beginRange[i], beginRange[i], cost[i]);
        }
        int left, right;
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("p")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                left = beginRange[a] + 1;
                right = endRange[a];
                root.add(left, right, b);
            } else {
                a = Integer.parseInt(st.nextToken());
                sb.append(root.find(beginRange[a])).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void eulerDFS(int cur) {
        beginRange[cur] = ++count;
        for (Integer child : children[cur]) {
            eulerDFS(child);
        }
        endRange[cur] = count;
    }
}