package com.codingtest.algorithm.acmicpc.q6515;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int RANGE = 100000;
    static int n, m, sq, res;
    static int[] cnt, ccnt;

    static class Query implements Comparable<Query> {

        int idx;
        int s;
        int e;

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
        StringTokenizer st;
        inputNM(br);
        while(n != 0){
            sq = (int) Math.sqrt(n);
            res = 0;
            int[] arr = new int[n + 1];
            int[] ans = new int[m];
            cnt = new int[RANGE * 2 + 1];
            ccnt = new int[RANGE * 2 + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) + RANGE;
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
                while (s > qs[i].s)
                    plus(arr[--s]);
                while (e < qs[i].e)
                    plus(arr[++e]);
                while (s < qs[i].s)
                    minus(arr[s++]);
                while (e > qs[i].e)
                    minus(arr[e--]);
                ans[qs[i].idx] = res;
            }

            for (int an : ans) {
                sb.append(an).append("\n");
            }
            inputNM(br);
        }
        System.out.println(sb);
    }

    private static void inputNM(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if(st.hasMoreTokens())
            m = Integer.parseInt(st.nextToken());
    }

    private static void plus(int v){
        ccnt[cnt[v]]--;
        res = Math.max(res, ++cnt[v]);
        ccnt[cnt[v]]++;
    }

    private static void minus(int v){
        if(--ccnt[cnt[v]] == 0 && cnt[v] == res) res--;
        cnt[v]--;
        ccnt[cnt[v]]++;
    }
}