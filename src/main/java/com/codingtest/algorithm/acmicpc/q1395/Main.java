package com.codingtest.algorithm.acmicpc.q1395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree{
        int begin, end, mid, turnCnt;
        boolean lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            this.lazy = false;
            if(begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void turnInRange(int s, int e){
            propagate();
            if(e < begin || end < s) return;
            else if(s <= begin && end <= e){
                lazy = !lazy;
                propagate();
                return;
            }

            left.turnInRange(s, e);
            right.turnInRange(s, e);
            turnCnt = left.turnCnt + right.turnCnt;
        }

        public int getTurnCount(int s, int e){
            propagate();
            if(e < begin || end < s) return 0;
            else if(s <= begin && end <= e){
                return turnCnt;
            }

            return left.getTurnCount(s, e) + right.getTurnCount(s, e);
        }

        private void propagate(){
            if(!lazy) return;
            turnCnt = (end - begin + 1) - turnCnt;
            if(begin != end) {
                left.lazy = !left.lazy;
                right.lazy = !right.lazy;
            }
            lazy = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, a, b, c; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0){
                root.turnInRange(b, c);
            }else{
                sb.append(root.getTurnCount(b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
