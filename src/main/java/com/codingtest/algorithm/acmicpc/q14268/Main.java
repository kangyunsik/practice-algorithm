package com.codingtest.algorithm.acmicpc.q14268;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static List<Integer>[] children;
    static int[] left, right;

    static class SegmentTree {

        int begin, end, mid, lazy, cur;
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

        public int get(int idx) {
            propagate();
            if (begin == end) {
                return cur;
            }
            if (idx <= mid) {
                return left.get(idx);
            } else {
                return right.get(idx);
            }
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
        int q = Integer.parseInt(st.nextToken());

        left = new int[n + 1];
        right = new int[n + 1];
        children = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2, a; i <= n; i++) {
            a = Integer.parseInt(st.nextToken());
            children[a].add(i);
        }
        euler(1);

        SegmentTree root = new SegmentTree(1, n);
        for (int i = 0, a, b; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                root.add(left[a], right[a], b);
            } else {
                a = Integer.parseInt(st.nextToken());
                sb.append(root.get(left[a])).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void euler(int cur) {
        left[cur] = ++count;
        for (Integer child : children[cur]) {
            euler(child);
        }
        right[cur] = count;
    }
}