package com.codingtest.algorithm.acmicpc.q13546;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, cnt, bucket;
    static int n;
    static Deque<Integer>[] idxes;

    static final int sqrtN = 300;
    static final int MAX = 111111;

    static class Query implements Comparable<Query> {
        int idx, begin, end;

        public Query(int idx, int begin, int end) {
            this.idx = idx;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Query o) {
            if (begin / sqrtN == o.begin / sqrtN) return end - o.end;
            return begin - o.begin;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        cnt = new int[MAX];
        bucket = new int[MAX / sqrtN + 100];
        arr = new int[MAX];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(br.readLine());

        Query[] qs = new Query[q];
        for (int i = 0, a, b; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            qs[i] = new Query(i, a, b);
        }
        Arrays.sort(qs);

        idxes = new Deque[MAX];
        for (int i = 0; i < MAX; i++) {
            idxes[i] = new ArrayDeque<>();
        }

        int[] ans = new int[q];
        int s = qs[0].begin, e = qs[0].end;
        for (int i = s; i <= e; i++) {
            append(i, true);
        }
        ans[qs[0].idx] = getDiffByBucket();

        for (int i = 1; i < q; i++) {
            while (s > qs[i].begin) append(--s, false);
            while (e < qs[i].end) append(++e, true);
            while (s < qs[i].begin) erase(s++, false);
            while (e > qs[i].end) erase(e--, true);
            ans[qs[i].idx] = getDiffByBucket();
        }
        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    private static int getDiffByBucket() {
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == 0) continue;
            for (int j = sqrtN - 1; j >= 0; j--) {
                if (cnt[i * sqrtN + j] > 0) {
                    return i * sqrtN + j;
                }
            }
        }
        return 0;
    }

    private static void append(int idx, boolean isRight) {
        Deque<Integer> dq = idxes[arr[idx]];
        if (!dq.isEmpty()) recordMinus(idx);
        if (isRight) dq.addLast(idx);
        else dq.addFirst(idx);
        recordPlus(idx);
    }

    private static void erase(int idx, boolean isRight) {
        Deque<Integer> dq = idxes[arr[idx]];
        recordMinus(idx);
        if (isRight) dq.removeLast();
        else dq.removeFirst();
        if (!dq.isEmpty()) recordPlus(idx);
    }

    private static void recordPlus(int idx) {
        Deque<Integer> dq = idxes[arr[idx]];
        int temp = dq.getLast() - dq.getFirst();
        cnt[temp]++;
        bucket[temp / sqrtN]++;
    }

    private static void recordMinus(int idx) {
        Deque<Integer> dq = idxes[arr[idx]];
        int temp = dq.getLast() - dq.getFirst();
        cnt[temp]--;
        bucket[temp / sqrtN]--;
    }
}