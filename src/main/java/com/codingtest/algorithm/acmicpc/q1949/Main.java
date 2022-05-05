package com.codingtest.algorithm.acmicpc.q1949;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[][] dp;
    static List<Integer>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        edges = new List[n + 1];
        dp = new int[2][n + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            edges[i] = new ArrayList<>();
        }
        for (int i = 0, a, b; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        int root = findAnyRoot();
        int ans = dfs(root, -1, 0);
        System.out.println(ans);
    }

    // avail == 0 then select this cur possible.
    private static int dfs(int cur, int parent, int avail){
        if(dp[avail][cur] != -1) return dp[avail][cur];

        int ret = 0;
        if(avail == 1){
            for (int child : edges[cur]) {
                if(child == parent) continue;
                ret += dfs(child, cur, 0);
            }
        }else{
            int selectCase = arr[cur];
            int noneCase = 0;
            for (int child : edges[cur]) {
                if(child == parent) continue;
                selectCase += dfs(child, cur, 1);
                noneCase += dfs(child, cur, 0);
            }
            ret = Math.max(selectCase, noneCase);
        }
        return dp[avail][cur] = ret;
    }

    private static int findAnyRoot() {
        for (int i = 1; i <= n; i++) {
            if(edges[i].size() == 1) return i;
        }
        return 1;
    }
}