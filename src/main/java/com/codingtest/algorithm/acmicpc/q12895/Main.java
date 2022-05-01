package com.codingtest.algorithm.acmicpc.q12895;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        int begin, end, mid, cur, lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            this.cur = 1;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void set(int l, int r, int v) {
            propagate();
            if (r < begin || end < l) {
                return;
            } else if (l <= begin && end <= r) {
                lazy = v;
                propagate();
                return;
            }
            left.set(l, r, v);
            right.set(l, r, v);
            cur = left.cur | right.cur;
        }

        public int find(int l, int r) {
            propagate();
            if (r < begin || end < l) {
                return 0;
            } else if (l <= begin && end <= r) {
                return cur;
            }
            return left.find(l, r) | right.find(l, r);
        }

        private void propagate() {
            if (lazy == 0) {
                return;
            }
            cur = lazy;
            if (begin != end) {
                left.lazy = lazy;
                right.lazy = lazy;
            }
            lazy = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st.nextToken();
        int q = Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        for (int i = 0, a, b, c; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("C")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken()) - 1;
                if(a < b){
                    root.set(a, b, 1 << c);
                }else{
                    root.set(b, a, 1 << c);
                }
            } else {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if(a < b){
                    sb.append(Integer.bitCount(root.find(a, b))).append("\n");
                }else{
                    sb.append(Integer.bitCount(root.find(b, a))).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}