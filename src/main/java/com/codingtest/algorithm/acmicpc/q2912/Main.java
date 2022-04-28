package com.codingtest.algorithm.acmicpc.q2912;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, color, sq;
    static int[] cnt = new int[11111];
    static Query[] qs;
    static String[] ans;

    static class Query implements Comparable<Query> {
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
        n = Integer.parseInt(st.nextToken());
        color = Integer.parseInt(st.nextToken());
        sq = (int) Math.sqrt(n);
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        ans = new String[m];
        qs = new Query[m];

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            qs[i] = new Query(i, a, b);
        }
        Arrays.sort(qs);

        int s = qs[0].s, e = qs[0].e;
        for (int i = s; i <= e; i++) cnt[arr[i]]++;
        setAns(0, s, e);

        for (int i = 1; i < m; i++) {
            while (s > qs[i].s) cnt[arr[--s]]++;
            while (e < qs[i].e) cnt[arr[++e]]++;
            while (s < qs[i].s) cnt[arr[s++]]--;
            while (e > qs[i].e) cnt[arr[e--]]--;
            setAns(i, s, e);
        }

        StringBuilder sb = new StringBuilder();
        for (String an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    private static void setAns(int i, int s, int e) {
        int dist = (e - s + 1) / 2;
        int v = findV(dist);
        if (v == -1) ans[qs[i].idx] = "no";
        else ans[qs[i].idx] = "yes " + v;
    }

    private static int findV(int dist) {
        for (int i = 1; i <= color; i++) {
            if (cnt[i] > dist) return i;
        }
        return -1;
    }
}