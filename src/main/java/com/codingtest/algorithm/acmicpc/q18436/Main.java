package com.codingtest.algorithm.acmicpc.q18436;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int begin, end, mid, even;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void push(int idx, int val) {
            if ((val & 1) == 0) even++;
            if (begin == end) return;
            if (idx <= mid) left.push(idx, val);
            else right.push(idx, val);
        }

        public void change(int idx, int val) {
            if (idx < begin || end < idx) return;
            else if (begin == end) {
                if ((val & 1) == even) {
                    even = 1 - even;
                }
                return;
            }
            left.change(idx, val);
            right.change(idx, val);
            this.even = left.getEven(begin, mid) + right.getEven(mid + 1, end);
        }

        public int getOdd(int l, int r) {
            if (r < begin || end < l) return 0;
            else if (l <= begin && end <= r) return getOdd();
            return left.getOdd(l, r) + right.getOdd(l, r);
        }

        public int getEven(int l, int r) {
            if (r < begin || end < l) return 0;
            else if (l <= begin && end <= r) return even;
            return left.getEven(l, r) + right.getEven(l, r);
        }

        private int getOdd() {
            return end - begin + 1 - even;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(1, n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            root.push(i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    root.change(b, c);
                    break;
                case 2:
                    sb.append(root.getEven(b, c)).append("\n");
                    break;
                case 3:
                    sb.append(root.getOdd(b, c)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}