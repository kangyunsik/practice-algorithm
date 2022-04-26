package com.codingtest.algorithm.acmicpc.q13547;

import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

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
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        k = (int) Math.sqrt(n + 1);
        int[] arr = new int[n + 1];
        int[] cnt = new int[1000001];
        int cur = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] ans = new int[m];
        Query[] queries = new Query[m];
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            queries[i] = new Query(i, a, b);
        }
        Arrays.sort(queries);

        int s = queries[0].s, e = queries[0].e;
        for (int i = s; i <= e; i++) {
            if (cnt[arr[i]]++ == 0) cur++;
        }
        ans[queries[0].idx] = cur;

        for (int i = 1; i < m; i++) {
            while (s < queries[i].s) if (--cnt[arr[s++]] == 0) cur--;
            while (s > queries[i].s) if (cnt[arr[--s]]++ == 0) cur++;
            while (e < queries[i].e) if (cnt[arr[++e]]++ == 0) cur++;
            while (e > queries[i].e) if (--cnt[arr[e--]] == 0) cur--;
            ans[queries[i].idx] = cur;
        }
        for (int a : ans) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}