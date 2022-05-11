package com.codingtest.algorithm.acmicpc.q11377;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] edges;
    static List<Integer> matchLeft;
    static int[] works, fast;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        matchLeft = new ArrayList<>();
        edges = new List[n + 1];
        works = new int[m + 1];
        visit = new boolean[n + 1];
        fast = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            for (int j = 0, v; j < q; j++) {
                v = Integer.parseInt(st.nextToken());
                edges[i].add(v);
            }
        }

        int cur = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(i)) {
                matchLeft.add(i);
                cur++;
                Arrays.fill(visit, false);
            }
        }
        Arrays.fill(visit, false);

        for (int i = 0; i < matchLeft.size() && k > 0; i++) {
            if(dfs(matchLeft.get(i))){
                k--;
                cur++;
                Arrays.fill(visit, false);
            }
        }
        System.out.println(cur);
    }

    private static boolean dfs(int cur) {
        visit[cur] = true;
        for (Integer to : edges[cur]) {
            int next = works[to];
            if (next == 0 || (!visit[next] && dfs(next))) {
                works[to] = cur;
                return true;
            }
        }
        return false;
    }
}