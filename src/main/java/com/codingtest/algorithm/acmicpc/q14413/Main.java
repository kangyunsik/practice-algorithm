package com.codingtest.algorithm.acmicpc.q14413;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] cnt = new int[500001];
    static int sq, res;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> mapper = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        sq = (int) Math.sqrt(n);
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 1, input; i <= n; i++) {
            input = Integer.parseInt(st.nextToken());
            if(mapper.containsKey(input)){
                arr[i] = mapper.get(input);
            }else{
                arr[i] = mapper.size();
                mapper.put(input, arr[i]);
            }
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
        for (int i = 1; i < m; i++) {
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
        if(cnt[v] == 2) res--;
        if(++cnt[v] == 2) res++;
    }

    private static void minus(int v){
        if(cnt[v] == 2) res--;
        if(--cnt[v] == 2) res++;
    }
}