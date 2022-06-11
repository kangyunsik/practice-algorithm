package com.codingtest.algorithm.acmicpc.q2268;

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
            else if (idx == begin && begin == end) {
                this.sum = val;
                return;
            }
            left.setValue(idx, val);
            right.setValue(idx, val);
            this.sum = left.sum + right.sum;
        }

        public long getValue(int l, int r) {
            if (r < begin || end < l) return 0L;
            else if (l <= begin && end <= r) {
                return this.sum;
            }
            return left.getValue(l, r) + right.getValue(l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        SegmentTree root = new SegmentTree(1, n);

        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0){
                if(b < c) sb.append(root.getValue(b, c)).append("\n");
                else sb.append(root.getValue(c, b)).append("\n");
            }else{
                root.setValue(b, c);
            }
        }
        System.out.println(sb);
    }
}