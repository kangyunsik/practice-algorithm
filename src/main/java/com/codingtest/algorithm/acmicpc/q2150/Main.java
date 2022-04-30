package com.codingtest.algorithm.acmicpc.q2150;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] edges;
    static List<Integer>[] revEdges;
    static boolean[] dfsVisit;
    static boolean[] sccVisit;
    static Stack<Integer> stack;
    static List<Integer> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> ansList = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        revEdges = new List[n + 1];
        dfsVisit = new boolean[n + 1];
        sccVisit = new boolean[n + 1];
        stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList();
            revEdges[i] = new ArrayList();
        }

        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            revEdges[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (dfsVisit[i]) {
                continue;
            }
            dfs(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            temp = new ArrayList<>();
            if(sccVisit[pop]) continue;
            scc(pop);
            Collections.sort(temp);
            ansList.add(temp);
        }
        Collections.sort(ansList, Comparator.comparingInt(l -> l.get(0)));
        sb.append(ansList.size()).append("\n");
        for (List<Integer> list : ansList) {
            for (int t : list) {
                sb.append(t).append(" ");
            }
            sb.append("-1\n");
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

    private static void scc(int idx) {
        temp.add(idx);
        sccVisit[idx] = true;
        for (int next : revEdges[idx]) {
            if (sccVisit[next]) {
                continue;
            }
            scc(next);
        }
    }
}