package com.codingtest.algorithm.acmicpc.q9345;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        int begin, end, mid, min, max;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = this.min = begin;
            this.end = this.max = end;
            this.mid = (begin + end) / 2;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void update(int idx, int v) {
            if (begin == end) {
                min = max = v;
                return;
            }
            if (idx <= mid) {
                left.update(idx, v);
            } else {
                right.update(idx, v);
            }
            min = Math.min(left.min, right.min);
            max = Math.max(left.max, right.max);
        }

        public boolean query(int l, int r) {
            if (r < begin || end < l) {
                return true;
            } else if (l <= begin && end <= r) {
                return l <= min && max <= r;
            }
            return left.query(l, r) && right.query(l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] idxes;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n, m;
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            idxes = new int[n];
            for (int i = 0; i < n; i++) {
                idxes[i] = i;
            }

            SegmentTree root = new SegmentTree(0, n - 1);
            for (int i = 0, a, b, c; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    sb.append(root.query(b, c) ? "YES\n" : "NO\n");
                } else {
                    int bIdx = idxes[b];
                    int cIdx = idxes[c];
                    idxes[b] = cIdx;
                    idxes[c] = bIdx;
                    root.update(bIdx, c);
                    root.update(cIdx, b);
                }
            }
        }
        System.out.print(sb);
    }
}