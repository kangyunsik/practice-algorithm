package com.codingtest.algorithm.acmicpc.q10999;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        SegmentTree segmentTree = new SegmentTree(1, n);
        for (int i = 1; i <= n; i++) {
            segmentTree.lazyUpdate(i, i, Long.parseLong(br.readLine()));
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().equals("1")) {
                segmentTree.lazyUpdate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            } else {
                sb.append(segmentTree.find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static class SegmentTree {
        long sum, lazyValue;
        int s, e, m;
        SegmentTree left, right;

        public SegmentTree(int s, int e) {
            this.s = s;
            this.e = e;
            this.m = (s + e) / 2;
            this.sum = 0;

            if (s != e) {
                left = new SegmentTree(s, m);
                right = new SegmentTree(m + 1, e);
            }
        }

        public long find(int begin, int end) {
            propagate();
            if (e < begin || end < s) return 0;
            if (begin <= s && e <= end) {
                return sum;
            }

            return left.find(begin, end) + right.find(begin, end);
        }

        public void lazyUpdate(int begin, int end, long value) {
            propagate();
            if (e < begin || end < s) return;
            if (begin <= s && e <= end) {
                lazyValue = value;
                propagate();
                return;
            }

            sum = 0;
            if (left != null) {
                left.lazyUpdate(begin, end, value);
                sum += left.sum;
            }
            if (right != null) {
                right.lazyUpdate(begin, end, value);
                sum += right.sum;
            }
        }

        private void propagate() {
            if (lazyValue == 0) return;
            sum += (e - s + 1) * lazyValue;
            if (left != null) {
                left.lazyValue += lazyValue;
            }
            if (right != null) {
                right.lazyValue += lazyValue;
            }
            lazyValue = 0;
        }
    }

}
