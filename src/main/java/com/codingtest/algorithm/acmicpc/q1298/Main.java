package com.codingtest.algorithm.acmicpc.q1298;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static int[] comp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        comp = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(dfs(i)){
                ans++;
                Arrays.fill(visit, false);
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int cur){
        visit[cur] = true;
        for (Integer to : edges[cur]) {
            int next = comp[to];
            if(next == 0 || (!visit[next] && dfs(next))){
                comp[to] = cur;
                return true;
            }
        }
        return false;
    }
}