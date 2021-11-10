package com.codingtest.algorithm.acmicpc.q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> []edges;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(edges[i+1]);
        }

        dfs(edges,v, new boolean[n+1]);
        System.out.println();
        bfs(edges,v);
    }

    private static void dfs(List<Integer> []edges, int v, boolean[] check){
        if(!check[v]) {
            System.out.print(v + " ");
            check[v] = true;
            for (Integer next : edges[v]) {
                dfs(edges,next,check);
            }
        }
    }

    private static void bfs(List<Integer> []edges, int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[edges.length];
        q.offer(v);
        while(!q.isEmpty()){
            Integer poll = q.poll();
            if(!check[poll]) {
                System.out.print(poll+" ");
                for (Integer next : edges[poll]) {
                    q.offer(next);
                }
            }
            check[poll] = true;
        }
    }
}

