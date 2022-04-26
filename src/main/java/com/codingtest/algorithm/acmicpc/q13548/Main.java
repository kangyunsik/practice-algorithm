package com.codingtest.algorithm.acmicpc.q13548;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k, maxIdx = 0;
    public static final int MAX_VALUE = 100000;
    static int[] cnt = new int[MAX_VALUE + 1];
    static int[] cnts = new int[MAX_VALUE + 1];

    static class Query implements Comparable<Query> {
        int idx, s, e;

        public Query(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Query o) {
            if (s / k == o.s / k) return e - o.e;
            return s / k - o.s / k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = (int) Math.sqrt(n);
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        Query[] qs = new Query[m];
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            qs[i] = new Query(i, a, b);
        }
        Arrays.sort(qs);

        int[] ans = new int[m];
        int s = 0, e = 0;
        maxIdx = 0;
        for (int i = 0; i < m; i++) {
            while (s > qs[i].s) plus(arr[--s]);
            while (e < qs[i].e) plus(arr[++e]);
            while (s < qs[i].s) minus(arr[s++]);
            while (e > qs[i].e) minus(arr[e--]);
            ans[qs[i].idx] = maxIdx;
        }

        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.print(sb);
    }

    private static void minus(int v) {
        cnts[cnt[v]]--;
        if (cnt[v] == maxIdx && cnts[cnt[v]] == 0) maxIdx--;
        cnt[v]--;
        if (cnt[v] >= 0) cnts[cnt[v]]++;
    }

    private static void plus(int v) {
        if (cnt[v] != 0) cnts[cnt[v]]--;
        cnt[v]++;
        cnts[cnt[v]]++;
        maxIdx = Math.max(maxIdx, cnt[v]);
    }
}