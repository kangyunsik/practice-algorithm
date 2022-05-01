package com.codingtest.algorithm.acmicpc.q12999;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int RANGE = 100000;
    static int sq, res;
    static int[] cnt = new int[RANGE * 2 + 1];
    static int[] ccnt = new int[RANGE + 1];

    static class Query implements Comparable<Query> {

        int idx, s, e;

        public Query(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Query o) {
            if (s / sq == o.s / sq) {
                return e - o.e;
            }
            return s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        sq = (int) Math.sqrt(n);
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[RANGE * 2 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + RANGE;
        }

        Query[] qs = new Query[m];
        int[] ans = new int[m];
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

        for (int i = 1; i < m; i++) {
            while (s > qs[i].s) {
                plus(arr[--s]);
            }
            while (e < qs[i].e) {
                plus(arr[++e]);
            }
            while (s < qs[i].s) {
                minus(arr[s++]);
            }
            while (e > qs[i].e) {
                minus(arr[e--]);
            }
            ans[qs[i].idx] = res;
        }

        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.print(sb);
    }

    private static void plus(int v) {
        ccnt[cnt[v]]--;
        cnt[v]++;
        ccnt[cnt[v]]++;
        res = Math.max(res, cnt[v]);
    }

    private static void minus(int v) {
        if(--ccnt[cnt[v]] == 0 && cnt[v] == res) res--;
        cnt[v]--;
        ccnt[cnt[v]]++;
    }
}