package com.codingtest.algorithm.acmicpc.q1414;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Edge> edges;
    static int[] parent;

    static class Edge implements Comparable<Edge> {

        int v, w, weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        edges = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = input.charAt(j);
                int v = getValue(c);
                if(v == 0) continue;
                sum += v;
                edges.add(new Edge(i, j, v));
            }
        }

        int cnt = 0;
        Collections.sort(edges);
        for (int i = 0; i < edges.size() && cnt < n - 1; i++) {
            Edge edge = edges.get(i);
            if(union(edge.v, edge.w)) {
                cnt++;
                sum -= edge.weight;
            }
        }

        if (cnt == n - 1) {
            System.out.println(sum);
        }else{
            System.out.println("-1");
        }
    }

    private static boolean union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return false;
        parent[a] = b;
        return true;
    }

    private static int getParent(int a) {
        if(a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static int getValue(char c) {
        if(Character.isAlphabetic(c)){
            if(Character.isLowerCase(c)) return c - 'a' + 1;
            else return c - 'A' + 27;
        }
        return 0;
    }
}