package com.codingtest.algorithm.acmicpc.q10070;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] ans;
    static final int INF = 1000000000;

    static class SegmentTree {

        int begin, end, mid, lower, upper;
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

        public void plus(int op, int l, int r, int v) {
            if (r < begin || end < l) {
                return;
            } else if (l <= begin && end <= r) {
                propagate(op, v);
                ans[l] = lower;
                return;
            }
            left.propagate(1, lower);
            left.propagate(2, upper);
            right.propagate(1, lower);
            right.propagate(2, upper);
            lower = 0;
            upper = INF;
            left.plus(op, l, r, v);
            right.plus(op, l, r, v);
        }

        private void propagate(int op, int v) {
            if (op == 1) {
                lower = Math.max(lower, v);
                upper = Math.max(upper, v);
            } else {
                lower = Math.min(lower, v);
                upper = Math.min(upper, v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ans = new int[n];
        SegmentTree root = new SegmentTree(0, n - 1);
        for (int i = 0, a, b, c, d; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            root.plus(a, b, c, d);
        }

        for (int i = 0; i < n; i++) {
            root.plus(1, i, i, 0);
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
}