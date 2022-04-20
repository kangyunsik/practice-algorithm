package com.codingtest.algorithm.acmicpc.q12844;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        int begin, end, mid, value, lazyValue;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public int findValue(int s, int e) {
            propagate();
            if (end < s || e < begin) return 0;
            if (s <= begin && end <= e) return value;
            return left.findValue(s, e) ^ right.findValue(s, e);
        }

        public void lazyXOR(int s, int e, int value) {
            propagate();
            if (end < s || e < begin) return;
            else if (s <= begin && end <= e) {
                if(isOddRange()) this.value ^= value;
                if(begin != end){
                    left.lazyValue ^= value;
                    right.lazyValue ^= value;
                }
                return;
            }

            left.lazyXOR(s, e, value);
            right.lazyXOR(s, e, value);
            this.value = left.value ^ right.value;
        }

        private void propagate() {
            if (lazyValue == 0) return;
            if (isOddRange()) value ^= lazyValue;
            if (left != null) left.lazyValue ^= lazyValue;
            if (right != null) right.lazyValue ^= lazyValue;
            lazyValue = 0;
        }

        private boolean isOddRange() {
            return (end - begin) % 2 == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        SegmentTree root = new SegmentTree(0, n - 1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            root.lazyXOR(i, i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b, c, d; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                root.lazyXOR(b, c, d);
            } else {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                sb.append(root.findValue(b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
