package com.codingtest.algorithm.acmicpc.q4195;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> mapper;
    static int cnt;
    static int[] parent = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String a, b;
        int idxA, idxB;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            init(n);
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = st.nextToken();
                b = st.nextToken();
                idxA = getOrSet(a);
                idxB = getOrSet(b);
                union(idxA, idxB);

                bw.write(String.valueOf(getSize(idxA)));
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static void init(int n) {
        cnt = 0;
        mapper = new HashMap<>();
        Arrays.fill(parent, 1, n * 2 + 1, -1);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return;
        if (getSize(a) > getSize(b)) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    private static int getParent(int a) {
        if (parent[a] < 0) return a;
        else return parent[a] = getParent(parent[a]);
    }

    private static int getSize(int a) {
        a = getParent(a);
        return -parent[a];
    }

    private static int getOrSet(String a) {
        if (mapper.containsKey(a)) {
            return mapper.get(a);
        } else {
            mapper.put(a, ++cnt);
            return cnt;
        }
    }
}
