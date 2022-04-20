package com.codingtest.algorithm.acmicpc.q15967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree{
        int begin, end, mid, lazy;
        long sum;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if(begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public long getSum(int s, int e){
            propagate();
            if(e < begin || end < s) return 0;
            else if(s <= begin && end <= e) return sum;
            return left.getSum(s, e) + right.getSum(s, e);
        }

        public void lazyUpdate(int s, int e, int v){
            propagate();
            if(e < begin || end < s) return;
            else if(s <= begin && end <= e){
                lazy += v;
                propagate();
                return;
            }
            left.lazyUpdate(s, e, v);
            right.lazyUpdate(s, e, v);
            sum = left.sum + right.sum;
        }

        private void propagate(){
            if(lazy == 0) return;
            sum += (long)(end - begin + 1) * lazy;
            if(begin != end){
                left.lazy += lazy;
                right.lazy += lazy;
            }
            lazy = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            root.lazyUpdate(i, i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0, a, b, c, d; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 1){
                sb.append(root.getSum(b, c)).append("\n");
            }else{
                d = Integer.parseInt(st.nextToken());
                root.lazyUpdate(b, c, d);
            }
        }
        System.out.println(sb);
    }
}
