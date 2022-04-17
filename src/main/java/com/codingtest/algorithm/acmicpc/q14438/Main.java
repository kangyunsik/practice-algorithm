package com.codingtest.algorithm.acmicpc.q14438;

import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int begin, end, mid;
        SegmentTree left, right;
        TreeMap<Integer, Integer> minTree;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            minTree = new TreeMap<>();
        }

        public void push(int idx, int value) {
            minTree.put(value, minTree.getOrDefault(value, 0) + 1);
            if (begin == end) {
                return;
            }
            if (idx <= mid) {
                if (left == null) left = new SegmentTree(begin, mid);
                left.push(idx, value);
            } else {
                if (right == null) right = new SegmentTree(mid + 1, end);
                right.push(idx, value);
            }
        }

        public void update(int idx, int value) {
            int prevValue = findMinByRange(idx, idx);
            removeByRange(idx, idx, prevValue);
            push(idx, value);
        }

        public int findMinByRange(int l, int r) {
            if (l == begin && r == end) {
                return minTree.firstKey();
            }
            if (r <= mid) {
                return left.findMinByRange(l, r);
            } else if (mid < l) {
                return right.findMinByRange(l, r);
            } else {
                return Math.min(left.findMinByRange(l, mid), right.findMinByRange(mid + 1, r));
            }
        }

        private void removeByRange(int l, int r, int value) {
            Integer remain = minTree.get(value);
            if (remain == 1) minTree.remove(value);
            else minTree.put(value, remain - 1);
            if (begin == end) {
                return;
            }

            if (r <= mid) {
                left.removeByRange(l, r, value);
            } else if (mid < l) {
                right.removeByRange(l, r, value);
            } else {
                left.removeByRange(l, mid, value);
                right.removeByRange(mid + 1, r, value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        SegmentTree root = new SegmentTree(1, n);
        for (int i = 1; i <= n; i++) {
            root.push(i, Integer.parseInt(st.nextToken()));
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0, a, b, c; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                root.update(b, c);
            } else {
                sb.append(root.findMinByRange(b, c)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
