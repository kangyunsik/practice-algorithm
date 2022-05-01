package com.codingtest.algorithm.acmicpc.q12899;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        int begin, end, mid, cnt;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void push(int idx) {
            cnt++;
            if (begin == end) {
                return;
            }
            if (idx <= mid) {
                left.push(idx);
            } else {
                right.push(idx);
            }
        }

        public int getCnt(int st) {
            cnt--;
            if (begin == end) {
                return begin;
            }
            if (st <= left.cnt) {
                return left.getCnt(st);
            } else {
                return right.getCnt(st - left.cnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        SegmentTree root = new SegmentTree(1, 2000000);
        for (int i = 0, a, b; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                root.push(b);
            } else {
                sb.append(root.getCnt(b)).append("\n");
            }
        }
        System.out.println(sb);
    }
}