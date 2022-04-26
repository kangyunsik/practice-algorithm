package com.codingtest.algorithm.acmicpc.q2243;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX_FAVOUR = 1000000;

    static class SegmentTree {
        int begin, end, mid, sum;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void put(int idx, int v) {
            this.sum += v;
            if(begin == end) return;
            if(idx <= mid) left.put(idx, v);
            else right.put(idx, v);
        }

        public int findValue(int remain){
            this.sum--;
            if(begin == end) return begin;
            if(left.sum < remain) return right.findValue(remain - left.sum);
            else return left.findValue(remain);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(1, MAX_FAVOUR);
        for (int i = 0, a, b, c; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int find = root.findValue(b);
                sb.append(find).append("\n");
            } else {
                c = Integer.parseInt(st.nextToken());
                root.put(b, c);
            }
        }
        System.out.println(sb);
    }
}