package com.codingtest.algorithm.acmicpc.q11376;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static int[] works;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new List[n * 2 + 1];
        works = new int[m + 1];
        visit = new boolean[n * 2 + 1];

        for (int i = 1; i <= n * 2; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            for (int j = 0, v; j < q; j++) {
                v = Integer.parseInt(st.nextToken());
                edges[i].add(v);
                edges[n + i].add(v);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n * 2; i++) {
            if(dfs(i)) {
                ans++;
                Arrays.fill(visit, false);
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int cur){
        visit[cur] = true;
        for (Integer to : edges[cur]) {
            int next = works[to];
            if(next == 0){
                works[to] = cur;
                return true;
            }
            if(!visit[next] && dfs(next)){
                works[to] = cur;
                return true;
            }
        }
        return false;
    }
}