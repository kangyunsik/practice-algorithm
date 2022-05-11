package com.codingtest.algorithm.acmicpc.q11375;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] works;
    static boolean[] visit;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        works = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            for (int j = 0; j < q; j++) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(i)) {
                ans++;
                Arrays.fill(visit, false);
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int cur) {
        visit[cur] = true;
        for (Integer to : edges[cur]) {
            int next = works[to];
            if(next == 0){
                works[to] = cur;
                return true;
            }
            if (!visit[next] && dfs(next)){
                works[to] = cur;
                return true;
            }
        }
        return false;
    }
}