package com.codingtest.algorithm.acmicpc.q1275;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int begin, end, mid;
        long sum;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void setValue(int idx, int val) {
            if (idx < begin || end < idx) return;
            else if (begin == idx && begin == end) {
                sum = val;
                return;
            }
            left.setValue(idx, val);
            right.setValue(idx, val);
            this.sum = left.sum + right.sum;
        }

        public long getSum(int l, int r) {
            if (r < begin || end < l) return 0L;
            else if (l <= begin && end <= r) {
                return sum;
            }
            return left.getSum(l, r) + right.getSum(l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            root.setValue(i, Integer.parseInt(st.nextToken()));
        }

        int x, y, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (x < y) sb.append(root.getSum(x, y)).append("\n");
            else sb.append(root.getSum(y, x)).append("\n");
            root.setValue(a, b);
        }
        System.out.println(sb);
    }
}