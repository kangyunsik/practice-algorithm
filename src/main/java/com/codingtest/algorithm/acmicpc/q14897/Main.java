package com.codingtest.algorithm.acmicpc.q14897;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int sq, res;
    static int[] cnt = new int[1000001];
    static Map<Integer, Integer> mapper;

    static class Query implements Comparable<Query> {
        int idx, s, e;

        public Query(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Query o) {
            if(s / sq == o.s / sq) return e - o.e;
            return s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        mapper = new HashMap<>(10000000);
        sq = (int) Math.sqrt(n);
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(mapper.containsKey(arr[i])) continue;
            mapper.put(arr[i], mapper.size());
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = mapper.get(arr[i]);
        }

        int q = Integer.parseInt(br.readLine());
        Query[] qs = new Query[q];
        int[] ans = new int[q];
        for (int i = 0, a, b; i < q; i++) {
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


        for (int i = 1; i < q; i++) {
            while(s > qs[i].s) plus(arr[--s]);
            while(e < qs[i].e) plus(arr[++e]);
            while(s < qs[i].s) minus(arr[s++]);
            while(e > qs[i].e) minus(arr[e--]);
            ans[qs[i].idx] = res;
        }
        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    private static void plus(int v){
        if(cnt[v]++ == 0) res++;
    }

    private static void minus(int v){
        if(--cnt[v] == 0) res--;
    }
}