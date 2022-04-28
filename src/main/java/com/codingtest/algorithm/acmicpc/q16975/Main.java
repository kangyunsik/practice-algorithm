package com.codingtest.algorithm.acmicpc.q16975;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        int begin, end, mid;
        long sum, lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void add(int l, int r, int v) {
            propagate();
            if (r < begin || end < l) return;
            else if (l <= begin && end <= r) {
                lazy += v;
                propagate();
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }

        public long find(int idx) {
            propagate();
            if (begin == end) return sum;
            if (idx <= mid) return left.find(idx);
            else return right.find(idx);
        }

        private void propagate() {
            if(lazy == 0) return;
            sum += lazy * (end - begin + 1);
            if(begin != end){
                left.lazy += lazy;
                right.lazy += lazy;
            }
            lazy = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(1, n);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            root.add(i, i, Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b, c, d; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                root.add(b, c, d);
            } else {
                sb.append(root.find(b)).append("\n");
            }
        }
        System.out.println(sb);
    }
}