package com.codingtest.algorithm.acmicpc.q14245;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        int begin, end, mid, value, lazyValue;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void setValue(int idx, int value) {
            if (begin == end) {
                this.value = value;
                return;
            }
            if (idx <= mid) left.setValue(idx, value);
            else right.setValue(idx, value);
        }

        public int findValue(int idx) {
            propagate();
            if (begin == end) return value;
            return idx <= mid ? left.findValue(idx) : right.findValue(idx);
        }

        public void lazyXOR(int s, int e, int value) {
            propagate();
            if (end < s || e < begin) return;
            else if (s <= begin && end <= e) {
                lazyValue ^= value;
                propagate();
                return;
            }
            if (left != null) left.lazyXOR(s, e, value);
            if (right != null) right.lazyXOR(s, e, value);
        }

        private void propagate() {
            if (lazyValue == 0) return;
            value ^= lazyValue;
            if (left != null) left.lazyValue ^= lazyValue;
            if (right != null) right.lazyValue ^= lazyValue;
            lazyValue = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(0, n - 1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            root.setValue(i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b, c, d; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                root.lazyXOR(b, c, d);
            } else {
                b = Integer.parseInt(st.nextToken());
                sb.append(root.findValue(b)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
