package com.codingtest.algorithm.acmicpc.q4196;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] edges;
    static Stack<Integer> stack;
    static boolean[] dfsVisit;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n, m;
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            cnt = 0;
            edges = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }
            stack = new Stack<>();

            for (int i = 0, a, b; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                edges[a].add(b);
            }

            dfsVisit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (dfsVisit[i]) {
                    continue;
                }
                dfs(i);
            }

            dfsVisit = new boolean[n + 1];
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (dfsVisit[pop]) {
                    continue;
                }
                dfs(pop);
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx) {
        dfsVisit[idx] = true;
        for (int next : edges[idx]) {
            if (dfsVisit[next]) {
                continue;
            }
            dfs(next);
        }
        stack.push(idx);
    }
}