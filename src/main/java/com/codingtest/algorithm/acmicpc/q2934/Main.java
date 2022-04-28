package com.codingtest.algorithm.acmicpc.q2934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        int begin, end, mid, sum, lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public int find(int idx) {
            propagate();
            int temp = sum;
            sum = 0;
            if (begin == end) return temp;
            if (idx <= mid) return left.find(idx);
            else return right.find(idx);
        }

        public void push(int l, int r) {
            propagate();
            if (r < begin || end < l) return;
            if (l <= begin && end <= r) {
                lazy += 1;
                propagate();
                return;
            }
            left.push(l, r);
            right.push(l, r);
            this.sum = left.sum + right.sum;
        }

        private void propagate() {
            if (lazy == 0) return;
            this.sum += lazy;
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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(1, 100000);
        for (int i = 0, a, b, ans; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = root.find(a) + root.find(b);
            if (a + 1 < b) root.push(a + 1, b - 1);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}