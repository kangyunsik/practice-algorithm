package com.codingtest.algorithm.acmicpc.q17353;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {

        int begin, end, mid;
        long lazy, sum;
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

        public void put(int l, int r, int v) {
            propagate();
            if (r < begin || end < l) {
                return;
            } else if (l <= begin && end <= r) {
                lazy += v;
                propagate();
                return;
            }
            left.put(l, r, v);
            right.put(l, r, v);
            this.sum = left.sum + right.sum;
        }

        public long get(int l, int r) {
            propagate();
            if (r < begin || end < l) {
                return 0;
            } else if (l <= begin && end <= r) {
                return sum;
            }
            return left.get(l, r) + right.get(l, r);
        }

        private void propagate() {
            if (lazy == 0) {
                return;
            }
            sum += lazy * (end - begin + 1);
            if (begin != end) {
                left.lazy += lazy;
                right.lazy += lazy;
            }
            lazy = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(1, n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = 0;
        for (int i = 1, v; i <= n; i++) {
            v = Integer.parseInt(st.nextToken());
            root.put(i, i, v - prev);
            prev = v;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b, c; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                c = Integer.parseInt(st.nextToken());
                root.put(b, c, 1);
                root.put(c + 1, c + 1, -(c - b + 1));
            } else {
                sb.append(root.get(1, b)).append("\n");
            }
        }
        System.out.println(sb);
    }
}