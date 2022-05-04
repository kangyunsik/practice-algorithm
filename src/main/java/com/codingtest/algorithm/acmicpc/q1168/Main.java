package com.codingtest.algorithm.acmicpc.q1168;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {

        int begin, end, mid, remain;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            remain = end - begin + 1;
            if (begin == end) {
                return;
            }
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public int getValue(int idx){
            remain--;
            if(begin == end) return begin;
            if(idx <= left.remain){
                return left.getValue(idx);
            }else{
                return right.getValue(idx - left.remain);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        int cur = 1;
        sb.append("<");
        for (int i = 0; i < n; i++) {
            cur += m - 1;
            cur = (cur - 1) % (n - i) + 1;
            sb.append(root.getValue(cur)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}