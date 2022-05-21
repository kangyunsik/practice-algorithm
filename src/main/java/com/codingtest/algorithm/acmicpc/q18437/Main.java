package com.codingtest.algorithm.acmicpc.q18437;

import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {

        int begin, end, mid, cnt, lazy;
        SegmentTree left, right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.mid = (begin + end) / 2;
            cnt = end - begin + 1;
            if (begin == end) return;
            left = new SegmentTree(begin, mid);
            right = new SegmentTree(mid + 1, end);
        }

        public void put(int l, int r, int turnOn) {
            propagate();
            if (r < begin || end < l) return;
            else if (l <= begin && end <= r) {
                lazy = turnOn;
                propagate();
                return;
            }
            left.put(l, r, turnOn);
            right.put(l, r, turnOn);
            cnt = left.cnt + right.cnt;
        }

        public int get(int l, int r) {
            propagate();
            if (r < begin || end < l) return 0;
            else if (l <= begin && end <= r) return cnt;
            return left.get(l, r) + right.get(l, r);
        }

        private void propagate() {
            if (lazy == 0) return;
            else if (lazy > 0) cnt = end - begin + 1;
            else cnt = 0;
            if (begin != end) {
                left.lazy = lazy;
                right.lazy = lazy;
            }
            lazy = 0;
        }
    }

    static List<Integer>[] children;
    static int[] inCnt, outCnt;
    static int cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        children = new List[n + 1];
        inCnt = new int[n + 1];
        outCnt = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        SegmentTree root = new SegmentTree(1, n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1, p; i <= n; i++) {
            p = Integer.parseInt(st.nextToken());
            children[p].add(i);
        }
        dfs(1);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                root.put(inCnt[b] + 1, outCnt[b], 1);
            } else if (a == 2) {
                root.put(inCnt[b] + 1, outCnt[b], -1);
            } else {
                sb.append(root.get(inCnt[b] + 1, outCnt[b])).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        inCnt[cur] = ++cnt;
        for (Integer child : children[cur]) {
            dfs(child);
        }
        outCnt[cur] = cnt;
    }
}