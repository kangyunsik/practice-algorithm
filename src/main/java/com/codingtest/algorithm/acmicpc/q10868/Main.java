package com.codingtest.algorithm.acmicpc.q10868;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        int begin;
        int end;
        int mid;
        int minValue;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            this.minValue = Integer.MAX_VALUE;
        }

        public void push(int idx, int value) {
            minValue = Math.min(minValue, value);
            if (begin == end) return;
            if (idx <= mid) {
                if (left == null) left = new SegmentTree(begin, mid);
                left.push(idx, value);
            } else {
                if (right == null) right = new SegmentTree(mid + 1, end);
                right.push(idx, value);
            }
        }

        public int getByRange(int l, int r) {
            if(begin == l && end == r) return minValue;
            int ret;
            if (r <= mid) {
                ret = left.getByRange(l, r);
            } else if (mid < l) {
                ret = right.getByRange(l, r);
            } else {
                ret = Math.min(left.getByRange(l, mid), right.getByRange(mid + 1, r));
            }
            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        SegmentTree segmentTree = new SegmentTree(1, n);
        for (int i = 1; i <= n; i++) {
            segmentTree.push(i, Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(segmentTree.getByRange(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }
}
