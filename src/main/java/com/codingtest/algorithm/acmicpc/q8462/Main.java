package com.codingtest.algorithm.acmicpc.q8462;

import java.io.*;
import java.util.*;

public class Main {
    static int[] cnt = new int[1000001];
    static long res;

    static class Query implements Comparable<Query> {
        static int sq;
        int idx, s, e;

        public Query(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Query o) {
            if (s / sq == o.s / sq) return e - o.e;
            return s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        long[] ans = new long[m];
        Query.sq = (int) Math.sqrt(n);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Query[] qs = new Query[m];
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            qs[i] = new Query(i, a, b);
        }
        Arrays.sort(qs);
        int s = qs[0].s, e = qs[0].e;
        for (int i = s; i <= e; i++) {
            plus(arr[i]);
        }
        ans[qs[0].idx] = res;

        for (int i = 0; i < m; i++) {
            while(s > qs[i].s) plus(arr[--s]);
            while(e < qs[i].e) plus(arr[++e]);
            while(s < qs[i].s) minus(arr[s++]);
            while(e > qs[i].e) minus(arr[e--]);
            ans[qs[i].idx] = res;
        }

        for (long an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    static void plus(int v){
        res += (2L * ++cnt[v] - 1) * v;
    }

    static void minus(int v){
        res -= (2L * --cnt[v] + 1) * v;
    }
}