package com.codingtest.algorithm.acmicpc.q11505;

import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    static Set<Integer> zeroIdx;

    static class SegmentTree {
        int begin, end, mid;
        long sum;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            this.sum = 1;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public long findInRange(int l, int r) {
            if (r < begin || end < l) return 1;
            else if (l <= begin && end <= r) return sum;
            return (left.findInRange(l, r) * right.findInRange(l, r)) % MOD;
        }

        public void setValue(int idx, int value) {
            long revValue = pow(findInRange(idx, idx), MOD - 2);
            long nextMul = (revValue * value) % MOD;
            multipleValue(idx, nextMul);
        }

        private long pow(long prevValue, int n) {
            long x = prevValue;
            long ret = 1L;
            while (n > 0) {
                if (n % 2 == 1) {
                    ret *= x;
                    ret %= MOD;
                }
                n /= 2;
                x *= x;
                x %= MOD;
            }
            return ret;
        }

        private void multipleValue(int idx, long nextMul) {
            this.sum *= nextMul;
            this.sum %= MOD;
            if (idx <= mid && left != null) left.multipleValue(idx, nextMul);
            else if (mid < idx && right != null) right.multipleValue(idx, nextMul);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        SegmentTree root = new SegmentTree(1, n);
        for (int i = 1; i <= n; i++) {
            root.setValue(i, Integer.parseInt(br.readLine()));
        }

        zeroIdx = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, a, b, c; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 1){
                if(c == 0){
                    zeroIdx.add(b);
                }else {
                    zeroIdx.remove(b);
                    root.setValue(b, c);
                }
            }else{
                if(containsZeroInRange(b, c)) sb.append("0\n");
                else sb.append(root.findInRange(b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean containsZeroInRange(int l, int r) {
        for (Integer idx : zeroIdx) {
            if(l <= idx && idx <= r) return true;
        }
        return false;
    }
}